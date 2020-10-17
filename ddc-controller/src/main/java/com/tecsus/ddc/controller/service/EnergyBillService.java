package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.builders.BillBuilder;
import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.builders.ClasseBuilder;
import com.tecsus.ddc.bills.energy.builders.EnergyBillBuilder;
import com.tecsus.ddc.bills.energy.builders.GroupBuilder;
import com.tecsus.ddc.bills.energy.enums.*;
import com.tecsus.ddc.controller.connector.Connector;
import org.joda.time.DateTime;
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
public class EnergyBillService implements BillService {

    private static final Logger log = LoggerFactory.getLogger(EnergyBillService.class);

    private Connector connector;

    public EnergyBillService(final Connector connector) {
        this.connector = connector;
        connector.connect();
    }

    @Override
    public Optional<Object> findById(final String idBill) {
        return Optional.empty();
    }

    @Override
    public <T> List<T> findAll() {
        String query = "SELECT * FROM bill, energy_bill WHERE bill.bill_num = energy_bill.abs_bill";
        return executeSelect(query);
    }

    @Override
    public <T> List<T> executeSelect(final String query) {
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            con = connector.getConnection();
            statement = con.createStatement();
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("Error when executing Query");
        }
        List<T> list = responseToList(rs);
        connector.close();
        closeStatement(statement);
        return list;
    }

    @Override
    public <T> List<T> responseToList(ResultSet rs) {
        List<EnergyBill> list = new ArrayList<>();
        try {
            while (rs.next()) {
                Bill absBill = new BillBuilder()
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
                EnergyBill bill = EnergyBillBuilder.anEnergyBill()
                        .bill(absBill)
                        .consumption(rs.getBigDecimal("consum_kwh"))
                        .tension(rs.getInt("tension"))
                        .group(
                                new GroupBuilder()
                                .group(Groups.valueOf(rs.getString("en_group")))
                                .subGroup(Subgroups.valueOf(rs.getString("en_sub_group")))
                                .build()
                        )
                        .classe(
                                new ClasseBuilder()
                                .classe(Classes.valueOf(rs.getString("en_class")))
                                .subClasse(SubClasses.valueOf(rs.getString("en_sub_class")))
                                .build()
                        )
                        .supplyType(SupplyType.valueOf(rs.getString("supply")))
                        .emission(new DateTime(rs.getDate("emission")))
                        .build();
                list.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeResultSet(rs);
        return (List<T>) list;
    }

    private void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeResultSet(ResultSet set) {
        try {
            if (set != null) {
                set.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
