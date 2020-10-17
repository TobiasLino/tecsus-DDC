package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.builders.BillBuilder;
import com.tecsus.ddc.client.builders.ClientBuilder;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.BillRepository;
import com.tecsus.ddc.dealership.Dealership;
import com.tecsus.ddc.dealership.builders.DealershipBuilder;
import com.tecsus.ddc.instalation.Instalation;
import com.tecsus.ddc.instalation.builders.AddressBuilder;
import com.tecsus.ddc.instalation.builders.InstalationBuilder;
import com.tecsus.ddc.utils.AbstractBillQueryBuilder;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
        executeInsert(AbstractBillQueryBuilder.getInsertQuery(bill));
    }

    private void executeInsert(final String query) {
        Statement statement = null;
        log.info("Executing insert");
        try {
            statement = connector.getConnection().createStatement();
            statement.executeUpdate(query);
            log.info("Inserted");
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("Insert failed");
        } finally {
            closeStatement(statement);
        }
    }

    @Override
    public Optional<Bill> findById(final String idBill) {
        return executeUniqueSelect(AbstractBillQueryBuilder.getSelectUniqueQuery(idBill));
    }

    private Optional<Bill> executeUniqueSelect(String query) {
        Statement statement = null;
        ResultSet rs = null;
        Bill res = null;
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
    public List<Bill> responseToList(final ResultSet rs) {
        List<Bill> list = new ArrayList<>();
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

    public Bill constructBillFromResultSet(final ResultSet rs) throws SQLException {
        return new BillBuilder()
                .instalation(
                        InstalationBuilder.anInstalation()
                        .numInst(rs.getString("num_inst"))
                        .address(
                                AddressBuilder.anAddress()
                                .zip(rs.getString("zip"))
                                .street(rs.getString("street"))
                                .num(rs.getString("num"))
                                .complement(rs.getString("complement"))
                                .neighborhood(rs.getString("neighborhood"))
                                .city(rs.getString("city"))
                                .uf(rs.getString("uf"))
                                .build()
                        )
                        .client(
                                ClientBuilder.aClient()
                                .name(rs.getString("name"))
                                .CNPJ(rs.getString("client_cnpj"))
                                .build()
                        )
                        .dealership(
                                DealershipBuilder.aDealership()
                                .id(rs.getInt("id_dealership"))
                                .CNPJ(rs.getString("deal_cnpj"))
                                .initials(rs.getString("initials"))
                                .site(rs.getString("site"))
                                .build()
                        )
                        .build())
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
        log.info("Closing statement");
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            log.info("Statement closed");
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
            log.info("ResultSet closed");
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("ResultSet close failed");
        }
    }
}
