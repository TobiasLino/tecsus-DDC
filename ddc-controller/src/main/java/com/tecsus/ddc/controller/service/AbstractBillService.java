package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.builders.BillBuilder;
import com.tecsus.ddc.controller.connector.Connector;
import org.joda.time.DateTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AbstractBillService implements BillService {

    private final Connector connector;

    public AbstractBillService(final Connector connector) {
        this.connector = connector;
        this.connector.connect();
    }

    @Override
    public Optional<Object> findById(final String idBill) {
        String query = "SELECT * FROM bill WHERE bill.bill_num = " + idBill;
        return executeUniqueSelect(query);
    }

    private Optional<Object> executeUniqueSelect(String query) {
        Statement statement = null;
        ResultSet rs = null;
        Bill res = null;
        try {
            statement = connector.getConnection().createStatement();
            rs = statement.executeQuery(query);
            res = constructBillFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeStatement(statement);
        return Optional.ofNullable(res);
    }

    @Override
    public <T> List<T> findAll() {
        return null;
    }

    @Override
    public <T> List<T> executeSelect(final String query) {
        return null;
    }

    @Override
    public <T> List<T> responseToList(final ResultSet rs) {
        List<Bill> list = new ArrayList<>();
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

    public Bill constructBillFromResultSet(ResultSet rs) throws SQLException {
        return new BillBuilder()
                .instalation(rs.getString("id_instalation"))
                .numConta(rs.getString("bill_num"))
                .valor(rs.getBigDecimal("total_value"))
                .vencimento(new DateTime(rs.getDate("due_date")))
                .mesReferencia(new DateTime(rs.getDate("ref_month")))
                .periodoConsumo(rs.getInt("consum_period"))
                .leituraAnterior(new DateTime(rs.getDate("previous_read")))
                .leituraAtual(new DateTime(rs.getDate("actual_read")))
                .leituraProxima(new DateTime(rs.getDate("next_read")))
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

    private void closeResultSet(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
