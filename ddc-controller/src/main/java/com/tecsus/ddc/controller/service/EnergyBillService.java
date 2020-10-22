package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.builders.EnergyBillBuilder;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.EnergyBillRepository;
import com.tecsus.ddc.utils.EnergyBillQueryFactory;
import org.joda.time.DateTime;
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
public class EnergyBillService implements EnergyBillRepository {

    private static final Logger log = LoggerFactory.getLogger(EnergyBillService.class);

    private Connector connector;

    public EnergyBillService(final Connector connector) {
        this.connector = connector;
        connector.connect();
    }

    @Override
    public void insert(final EnergyBill bill) {
        executeInsert(EnergyBillQueryFactory.getInsertQuery(bill));
    }

    private void executeInsert(final String query) {
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
    public Optional<EnergyBill> findById(final String idBill) {
        return executeUniqueSelect(EnergyBillQueryFactory.getSelectUniqueQuery(idBill));
    }

    private Optional<EnergyBill> executeUniqueSelect(final String query) {
        Statement statement = null;
        ResultSet rs = null;
        EnergyBill res = null;
        try {
            statement = connector.getConnection().createStatement();
            rs = statement.executeQuery(query);
            if (rs.next()) {
                res = constructEnergyBillFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeResultSet(rs);
        closeStatement(statement);
        return Optional.ofNullable(res);
    }

    @Override
    public List<EnergyBill> findAll() {
        return executeSelect(EnergyBillQueryFactory.getSelectQuery());
    }

    @Override
    public List<EnergyBill> executeSelect(final String query) {
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connector.getConnection().createStatement();
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("Error when executing Query");
        }
        List<EnergyBill> list = responseToList(rs);
        closeStatement(statement);
        return list;
    }

    @Override
    public List<EnergyBill> responseToList(ResultSet rs) {
        List<EnergyBill> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(constructEnergyBillFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeResultSet(rs);
        return list;
    }

    private EnergyBill constructEnergyBillFromResultSet(final ResultSet rs) throws SQLException {
        return EnergyBillBuilder.anEnergyBill()
                .consumption(rs.getBigDecimal("consum_kwh"))
                .tension(rs.getInt("tension"))
                .emission(new DateTime(rs.getDate("emission")))
                .build();
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

    private void closeResultSet(ResultSet set) {
        try {
            if (set != null && !set.isClosed()) {
                set.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
