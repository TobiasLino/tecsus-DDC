package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.EnergyBillFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.EnergyBillRepository;
import com.tecsus.ddc.query.EnergyBillQueryFactory;
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

    private ConnectionImpl connection;

    public EnergyBillService(final Connector connector) {
        this.connection = connector.getConnection();
    }

    @Override
    public void insert(final EnergyBill bill) {
        executeInsert(EnergyBillQueryFactory.getInsertQuery(bill));
    }

    private void executeInsert(final String query) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionImpl.closeStatement(statement);
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
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if (rs.next()) {
                res = EnergyBillFactory.constructEnergyBillFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionImpl.closeResultSet(rs);
        ConnectionImpl.closeStatement(statement);
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
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("Error when executing Query");
        }
        List<EnergyBill> energyBills = responseToList(rs);
        ConnectionImpl.closeStatement(statement);
        ConnectionImpl.closeResultSet(rs);
        return energyBills;
    }

    @Override
    public List<EnergyBill> responseToList(ResultSet rs) {
        List<EnergyBill> energyBills = new ArrayList<>();
        try {
            while (rs.next()) {
                energyBills.add(EnergyBillFactory.constructEnergyBillFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return energyBills;
    }
}
