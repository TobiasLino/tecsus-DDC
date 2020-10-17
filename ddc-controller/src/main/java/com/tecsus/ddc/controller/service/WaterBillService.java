package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.builders.BillBuilder;
import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.bills.water.builders.WaterBillBuilder;
import com.tecsus.ddc.controller.connector.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
public class WaterBillService implements BillService{

    private static final Logger log = LoggerFactory.getLogger(WaterBillService.class);

    private final Connector connector;
    private final AbstractBillService abstractBillService;

    public WaterBillService(final Connector connector) {
        this.connector = connector;
        this.abstractBillService = new AbstractBillService(connector);
        this.connector.connect();
    }

    @Override
    public Optional<Object> findById(final String idBill) {
        return Optional.empty();
    }

    @Override
    public <T> List<T> findAll() {
        String query = "SELECT * FROM bill, water_bill WHERE bill.bill_num = water_bill.abs_bill";
        return executeSelect(query);
    }

    @Override
    public <T> List<T> executeSelect(final String query) {
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connector.getConnection().createStatement();
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<T> list = responseToList(rs);
        closeStatement(statement);
        return list;
    }

    @Override
    public <T> List<T> responseToList(final ResultSet rs) {
        List<WaterBill> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(constructBillFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeResultSet(rs);
        return (List<T>)list;
    }

    private WaterBill constructBillFromResultSet(ResultSet rs) throws SQLException {
        return new WaterBillBuilder()
                .bill(abstractBillService.constructBillFromResultSet(rs))
                .build();
    }

    // TODO remover isso daqui e colocar em uma especialização se possível
    private void closeResultSet(ResultSet set) {
        try {
            if (set != null && !set.isClosed()) {
                set.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeStatement(Statement statement) {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
