package com.tecsus.ddc.bills;

import com.tecsus.ddc.instalation.Address;
import com.tecsus.ddc.instalation.Instalation;
import org.joda.time.DateTime;

import javax.ejb.ObjectNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BillFactory {

    public static Bill constructBillFromResultSet(final ResultSet rs) throws ObjectNotFoundException, SQLException {
        if (rs == null) {
            throw new ObjectNotFoundException("ResultSet is null");
        }
        return Bill.builder()
                .instalation(
                    Instalation.builder()
                        .numInst(rs.getString("num_inst"))
                        .address(Address.builder()
                            .zip(rs.getString("zip"))
                            .street(rs.getString("street"))
                            .num(rs.getString("num"))
                            .complement(rs.getString("complement"))
                            .neighborhood(rs.getString("neighborhood"))
                            .city(rs.getString("city"))
                            .uf(rs.getString("uf"))
                            .build())
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
}
