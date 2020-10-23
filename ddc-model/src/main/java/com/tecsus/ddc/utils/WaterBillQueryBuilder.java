package com.tecsus.ddc.utils;

import com.tecsus.ddc.bills.water.WaterBill;

/**
 * @author TOBIASDASILVALINO 
 */
public class WaterBillQueryBuilder {
    
    private WaterBill bill;

    private WaterBillQueryBuilder(final WaterBill bill) {
        this.bill = bill;
    }
    private WaterBillQueryBuilder() {

    }

    public static String getInsertQuery(final WaterBill bill) {
        return new WaterBillQueryBuilder(bill).constructInsert(bill);
    }

    public static String getSelectQuery() {
        return new WaterBillQueryBuilder().constructSelect();
    }

    public static String getSelectUniqueQuery(final String billNum) {
        return new WaterBillQueryBuilder().constructUniqueSelect(billNum);
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
