package com.tecsus.ddc.query;

import com.tecsus.ddc.bills.energy.EnergyBill;

import java.text.SimpleDateFormat;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
public class EnergyBillQueryFactory implements QueryFactory {

    private EnergyBill bill;

    private EnergyBillQueryFactory(final EnergyBill bill) {
        this.bill = bill;
    }

    private EnergyBillQueryFactory() {}

    @Override
    public Optional<String> createInsertQuery(final Object object) {
        if (object instanceof EnergyBill) {
            return Optional.ofNullable(new EnergyBillQueryFactory((EnergyBill) object).constructInsert());
        }
        return Optional.empty();
    }

    @Override
    public String createSelectQuery() {
        return new EnergyBillQueryFactory().constructSelect();
    }

    @Override
    public String createSelectUniqueQuery(final String billNum) {
        return new EnergyBillQueryFactory().constructUniqueSelect(billNum);
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
