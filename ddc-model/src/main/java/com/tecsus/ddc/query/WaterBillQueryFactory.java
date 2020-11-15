package com.tecsus.ddc.query;

import com.tecsus.ddc.bills.water.WaterBill;
import lombok.NoArgsConstructor;

/**
 * @author TOBIASDASILVALINO 
 */
@NoArgsConstructor
public class WaterBillQueryFactory implements QueryFactory<WaterBill> {

    @Override
    public <S extends WaterBill> String createInsertQuery(S object) {
        return constructInsert(object);
    }

    @Override
    public <S extends WaterBill> String createInsertQuery(S object, String id) {
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

    private String constructUniqueSelect(final String billNum) {
        return "SELECT d.*, i.*,ia.* ,cl.*, b.*, w.*" +
                "FROM dealership d INNER JOIN instalation i" +
                "ON d.id_dealership = i.id_dealer" +
                "INNER JOIN client cl"+
                "ON i.client_cnpj = cl.client_cnpj " +
                "INNER JOIN instalation_address ia " +
                "ON i.address = ia.zip " +
                "INNER JOIN bill b" +
                "ON b.id_instalation = i.num_inst" +
                "INNER JOIN water_bill w " +
                "ON b.bill_num  = w.abs_bill" +
                "WHERE b.bill_num = " + billNum;

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
