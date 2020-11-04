package com.tecsus.ddc.query;

import com.tecsus.ddc.bills.water.WaterBill;
import lombok.NoArgsConstructor;

/**
 * @author TOBIASDASILVALINO 
 */
@NoArgsConstructor
public class WaterBillQueryFactory implements QueryFactory {

    @Override
    public String createInsertQuery(final Object object) {
        if (object instanceof WaterBill) {
            return constructInsert((WaterBill) object);
        }
        return null;
    }

    @Override
    public String createSelectQuery() {
        return constructSelect();
    }

    @Override
    public String createSelectUniqueQuery(final String billNum) {
        return constructUniqueSelect(billNum);
    }

    @Override
    public String createSelectUniqueQuery(String id, String column) {
        return null;
    }


    private String constructSelect() {
        return "SELECT * FROM bill, water_bill, instalation, instalation_address, client, dealership " +
                "WHERE bill.bill_num = water_bill.abs_bill " +
                "and bill.id_instalation = instalation.num_inst " +
                "and instalation.address = instalation_address.zip " +
                "and instalation.client_cnpj = client.client_cnpj " +
                "and instalation.id_dealer = dealership.id_dealership";
    }

    private String constructUniqueSelect(String billNum) {
        return "select * from bill, water_bill, instalation, instalation_address, client, dealership " +
                "where bill.bill_num = '" + billNum + "' " +
                "and bill.bill_num = water_bill.abs_bill " +
                "and bill.id_instalation = instalation.num_inst " +
                "and instalation.address = instalation_address.zip " +
                "and instalation.client_cnpj = client.client_cnpj " +
                "and instalation.id_dealer = dealership.id_dealership";
    }

    private String constructInsert(final WaterBill bill) {
        return "INSERT INTO water_bill " +
                "(abs_bill, con_type, billing_type, consum_m3, water_val," +
                "sewer_val, trcf_val, tributes)" +
            "VALUES (" + "'" +
                bill.getBill().getNumConta() + "'," + "'" +
                bill.getConType().name() + "'," + "'" +
                bill.getBillingType().name() + "'," +
                bill.getConsum().toString() + "," +
                bill.getWater().toString() + "," +
                bill.getSewer().toString() + "," +
                bill.getTrcf().toString() + "," +
                bill.getTributes().toString() +
            ")";
    }
}
