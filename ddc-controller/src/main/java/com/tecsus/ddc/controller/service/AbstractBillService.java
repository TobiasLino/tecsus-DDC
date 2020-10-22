package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.BillFactory;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.BillRepository;
import com.tecsus.ddc.utils.AbstractBillQueryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ObjectNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class AbstractBillService implements BillRepository {

    private final Connector connector;

    private static Logger log = LoggerFactory.getLogger(AbstractBillService.class);

    public AbstractBillService(final Connector connector) {
        this.connector = connector;
        this.connector.connect();
    }

    @Override
    public void insert(final Bill bill) {
        executeInsert(AbstractBillQueryFactory.getInsertQuery(bill));
    }


    private void executeInsert(final String query) {
        Statement statement = null;
        try {
            log.debug("Executing insert: " + query);
            statement = connector.getConnection().createStatement();
            statement.executeUpdate(query);
            log.info("Inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("Insert failed");
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public Optional<Bill> findById(final String idBill) {
        return executeUniqueSelect(AbstractBillQueryFactory.getSelectUniqueQuery(idBill));
    }

    private Optional<Bill> executeUniqueSelect(String query) {
        Statement statement = null;
        ResultSet rs = null;
        Bill res = null;
        try {
            log.debug("Executing select: " + query);
            statement = connector.getConnection().createStatement();
            rs = statement.executeQuery(query);
            if (rs.next()) {
                res = BillFactory.constructBillFromResultSet(rs);
            }
            log.info("Select success.");
        } catch (SQLException | ObjectNotFoundException e) {
            log.info("Select Failed.");
            e.printStackTrace();
        }
        closeResultSet(rs);
        closeStatement(statement);
        return Optional.ofNullable(res);
    }

    private void closeStatement(Statement statement) {
        log.info("Closing statement");
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("Statement close failed");
        }
    }

    private void closeResultSet(ResultSet rs) {
        log.info("Closing ResultSet");
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("ResultSet close failed");
        }
    }
}
