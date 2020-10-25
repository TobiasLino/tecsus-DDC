package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.water.WaterBill;
import com.tecsus.ddc.bills.water.WaterBillFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.WaterBillRepository;
import com.tecsus.ddc.bills.water.WaterBillQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ObjectNotFoundException;
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

    private final ConnectionImpl connection;

    public WaterBillService(final Connector connector) {
        this.connection = connector.getConnection();
    }

    @Override
    public void insert(final WaterBill bill) {
        executeInsert(WaterBillQueryBuilder.getInsertQuery(bill));
    }

    private void executeInsert(String query) {
        Statement statement = null;
        try {
            log.debug(query);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            log.info("Inserted.");
        } catch (SQLException e) {
            log.error("Insert failed");
            e.printStackTrace();
        }
        ConnectionImpl.closeStatement(statement);
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
            log.debug(query);
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if (rs != null && rs.next()) {
                res = WaterBillFactory.constructBillFromResultSet(rs);
            }
            log.info("Select success.");
        } catch (SQLException | ObjectNotFoundException e) {
            log.error("Select Failed.");
            e.printStackTrace();
        }
        ConnectionImpl.closeResultSet(rs);
        ConnectionImpl.closeStatement(statement);
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
            log.debug(query);
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            log.info("Select success.");
        } catch (SQLException e) {
            log.error("Select Failed.");
            e.printStackTrace();
        }
        List<WaterBill> waterBills = responseToList(rs);
        ConnectionImpl.closeStatement(statement);
        ConnectionImpl.closeResultSet(rs);
        return waterBills;
    }

    @Override
    public List<WaterBill> responseToList(final ResultSet rs) {
        List<WaterBill> waterBills = new ArrayList<>();
        try {
            log.info("Trying to parse response to list..");
            while (rs.next()) {
                waterBills.add(WaterBillFactory.constructBillFromResultSet(rs));
            }
        } catch (SQLException | ObjectNotFoundException e) {
            log.error("Response to list Failed.");
            e.printStackTrace();
        }
        return waterBills;
    }
}
