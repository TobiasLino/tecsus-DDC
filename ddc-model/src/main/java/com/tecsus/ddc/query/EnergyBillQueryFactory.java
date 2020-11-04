package com.tecsus.ddc.query;

import com.tecsus.ddc.bills.energy.EnergyBill;
import lombok.NoArgsConstructor;

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

    public EnergyBillQueryFactory() {}

    @Override
    public String createInsertQuery(final Object object) {
        return new EnergyBillQueryFactory((EnergyBill) object).constructInsert();
    }

    @Override
    public String createSelectQuery() {
        return new EnergyBillQueryFactory().constructSelect();
    }

    @Override
    public String createSelectUniqueQuery(final String billNum) {
        return new EnergyBillQueryFactory().constructUniqueSelect(billNum);
    }

    @Override
    public String createSelectUniqueQuery(String id, String column) {
        return null;
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
        return "SELECT d.*,i.*, cl.*,b.*, eb.* " +
                "FROM dealership d inner join instalation i on d.id_dealership = i.id_dealer " +
                "INNER JOIN client cl on i.client_cnpj = cl.client_cnpj " +
                "INNER JOIN bill b on i.num_inst = b.id_instalation " +
                "INNER JOIN energy_bill eb on b.bill_num = eb.abs_bill " +
                "WHERE eb.id_energy_type = " + billNum;
    }
}
