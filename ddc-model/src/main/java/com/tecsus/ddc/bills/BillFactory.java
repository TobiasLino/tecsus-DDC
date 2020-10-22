package com.tecsus.ddc.bills;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.builders.BillBuilder;
import com.tecsus.ddc.client.builders.ClientBuilder;
import com.tecsus.ddc.dealership.builders.DealershipBuilder;
import com.tecsus.ddc.instalation.builders.AddressBuilder;
import com.tecsus.ddc.instalation.builders.InstalationBuilder;
import org.joda.time.DateTime;

import javax.ejb.ObjectNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BillFactory {

    public static Bill constructBillFromResultSet(final ResultSet rs) throws SQLException, ObjectNotFoundException {
        if (rs == null) {
            throw new ObjectNotFoundException("ResultSet is null");
        }
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
}
