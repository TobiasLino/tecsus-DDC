package com.tecsus.ddc.factory;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.instalation.Instalation;
import org.joda.time.DateTime;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillFactory implements Factory<Bill> {

    public Bill constructFrom(final ResultSet rs) {
        try {
            return Bill.builder()
                    .instalation(new InstalationFactory().constructFrom(rs))
                    .numConta(rs.getString("bill_num"))
                    .valor(rs.getBigDecimal("total_value"))
                    .vencimento(new DateTime(rs.getDate("due_date")))
                    .mesReferencia(new DateTime(rs.getDate("ref_month")))
                    .periodoConsumo(rs.getInt("consum_period"))
                    .leituraAnterior(new DateTime(rs.getDate("previous_read")))
                    .leituraAtual(new DateTime(rs.getDate("actual_read")))
                    .leituraProxima(new DateTime(rs.getDate("next_read")))
                    .build();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
