package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.BillFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.BillRepository;
import com.tecsus.ddc.bills.AbstractBillQueryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ObjectNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class AbstractBillService implements BillRepository {

    private final ConnectionImpl connection;

    private static Logger log = LoggerFactory.getLogger(AbstractBillService.class);

    public AbstractBillService(final Connector connector) {
        this.connection = connector.getConnection();
    }

    @Override
    public void insert(final Bill bill) {
        executeInsert(AbstractBillQueryFactory.getInsertQuery(bill));
    }


    private void executeInsert(final String query) {
        Statement statement = null;
        try {
            log.debug(query);
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Insert failed");
        } finally {
            ConnectionImpl.closeStatement(statement);
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
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if (rs.next()) {
                res = BillFactory.constructBillFromResultSet(rs);
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
}
