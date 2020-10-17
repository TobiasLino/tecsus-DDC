package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.bills.water.builders.WaterBillBuilder;
import com.tecsus.ddc.bills.water.enums.BillingType;
import com.tecsus.ddc.bills.water.enums.ConnectionType;
import com.tecsus.ddc.client.enums.State;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.WaterBillRepository;
import com.tecsus.ddc.utils.WaterBillQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
public class WaterBillService implements WaterBillRepository {

    private static final Logger log = LoggerFactory.getLogger(WaterBillService.class);

    private final Connector connector;
    private final AbstractBillService abstractBillService;

    public WaterBillService(final Connector connector) {
        this.connector = connector;
        this.abstractBillService = new AbstractBillService(connector);
        this.connector.connect();
    }

    @Override
    public void insert(final WaterBill bill) {
        executeInsert(WaterBillQueryBuilder.getInsertQuery(bill));
    }

    private void executeInsert(String query) {
        Statement statement = null;
        try {
            statement = connector.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeStatement(statement);
    }

    @Override
    public Optional<WaterBill> findById(final String idBill) {
        return executeUniqueSelect(WaterBillQueryBuilder.getSelectUniqueQuery(idBill));
    }

    private Optional<WaterBill> executeUniqueSelect(String query) {
        Statement statement = null;
        ResultSet rs = null;
        WaterBill res = null;
        try {
            statement = connector.getConnection().createStatement();
            rs = statement.executeQuery(query);
            if (rs.next()) {
                res = constructBillFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeResultSet(rs);
        closeStatement(statement);
        return Optional.ofNullable(res);
    }

    @Override
    public List<WaterBill> findAll() {
        return executeSelect(WaterBillQueryBuilder.getSelectQuery());
    }

    @Override
    public List<WaterBill> executeSelect(final String query) {
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connector.getConnection().createStatement();
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<WaterBill> list = responseToList(rs);
        closeStatement(statement);
        return list;
    }

    @Override
    public List<WaterBill> responseToList(final ResultSet rs) {
        List<WaterBill> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(constructBillFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeResultSet(rs);
        return list;
    }

    private WaterBill constructBillFromResultSet(ResultSet rs) throws SQLException {
        return WaterBillBuilder.aWaterBill()
                .bill(new AbstractBillService(connector).constructBillFromResultSet(rs))
                .id(rs.getInt("id_water_type"))
                .conType(ConnectionType.valueOf(rs.getString("con_type")))
                .billingType(BillingType.valueOf(rs.getString("billing_type")))
                .consum(rs.getBigDecimal("consum_m3"))
                .water(rs.getBigDecimal("water_val"))
                .sewer(rs.getBigDecimal("sewer_val"))
                .trcf(rs.getBigDecimal("trcf_val"))
                .tributes(rs.getBigDecimal("tributes"))
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
