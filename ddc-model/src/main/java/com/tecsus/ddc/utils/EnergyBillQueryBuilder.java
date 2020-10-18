package com.tecsus.ddc.utils;

import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.tributes.Tributes;

import java.text.SimpleDateFormat;

/**
 * @author TOBIASDASILVALINO
 */
public class EnergyBillQueryBuilder {

    private EnergyBill bill;

    private EnergyBillQueryBuilder(final EnergyBill bill) {
        this.bill = bill;
    }

    private EnergyBillQueryBuilder() {}

    public static String getInsertQuery(final EnergyBill bill) {
        return new EnergyBillQueryBuilder(bill).constructInsert();
    }

    public static String getSelectQuery() {
        return new EnergyBillQueryBuilder().constructSelect();
    }

    public static String getSelectUniqueQuery(final String billNum) {
        return new EnergyBillQueryBuilder().constructUniqueSelect(billNum);
    }

    private String constructInsert() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        return "INSERT INTO energy_bill" +
                "(abs_bill, consum_kwh, tension, emission, icms, tributes, financ_items) " +
            "VALUES(" + "'" +
                
            ")";
    }

    private String constructSelect() {
        return "select * from bill, energy_bill, instalation, instalation_address, client, dealership " +
                "where bill.bill_num = energy_bill.abs_bill " +
                "and bill.id_instalation = instalation.num_inst " +
                "and instalation.address = instalation_address.zip " +
                "and instalation.client_cnpj = client.client_cnpj " +
                "and instalation.id_dealer = dealership.id_dealership";
    }

    private String constructUniqueSelect(final String billNum) {
        return "select * from bill, energy_bill, instalation, instalation_address, client, dealership " +
                "where bill.bill_num = '" + billNum + "' " +
                "and bill.bill_num = energy_bill.abs_bill " +
                "and bill.id_instalation = instalation.num_inst " +
                "and instalation.address = instalation_address.zip " +
                "and instalation.client_cnpj = client.client_cnpj " +
                "and instalation.id_dealer = dealership.id_dealership";
    }
}
