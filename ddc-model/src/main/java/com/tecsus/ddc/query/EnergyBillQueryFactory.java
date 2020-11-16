package com.tecsus.ddc.query;

import com.tecsus.ddc.bills.energy.EnergyBill;

import java.text.SimpleDateFormat;

/**
 * @author TOBIASDASILVALINO
 */
public class EnergyBillQueryFactory implements QueryFactory<EnergyBill> {

    @Override
    public <S extends EnergyBill> String createInsertQuery(S energyBill) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YY");
        return "INSERT INTO energy_bill" +
                "(abs_bill, consum_kwh, tension, emission, icms, tributes, financ_items, supply, en_group, en_sub_group, en_class, en_sub_class, en_modalitie) " +
            "VALUES(" +
                (energyBill.getBill().getNumConta() != null ? "'" + energyBill.getBill().getNumConta() + "'" : "") + ", " +
                (energyBill.getConsumption() != null ? energyBill.getConsumption().toString() : "") + ", " +
                energyBill.getTension() + ", " +
                (energyBill.getEmission() != null ? "TO_DATE('" + formatter.format(energyBill.getEmission().toDate()) + "', 'dd/MM/yyyy')": "" ) + ", " +
                (energyBill.getIcms() != null ? energyBill.getIcms().toString() : "") + ", " +
                (energyBill.getTributes() != null ? energyBill.getTributes().toString() : "") + ", " +
                (energyBill.getFinancialItems() != null ? energyBill.getFinancialItems().toString() : "") +
                (energyBill.getSupplyType() != null ? energyBill.getSupplyType().name() : "") + ", " +
                ((energyBill.getGroup() != null) && (energyBill.getGroup().getGroup() != null) ? energyBill.getGroup().getGroup().name() : "") + ", " +
                ((energyBill.getGroup() != null) && (energyBill.getGroup().getSubGroup() != null) ? energyBill.getGroup().getSubGroup().name() : "") + ", " +
                ((energyBill.getClasse() != null) && (energyBill.getClasse().getClasse() != null) ? energyBill.getClasse().getClasse().name() : "") + ", " +
                ((energyBill.getClasse() != null) && (energyBill.getClasse().getSubClasses() != null) ? energyBill.getClasse().getSubClasses().name() : "") + ", " +
                (energyBill.getModalitie() != null  ? energyBill.getModalitie().name() : "") + ", " +
            ")";
    }

    @Override
    public <S extends EnergyBill> String createInsertQuery(S object, String id) {
        return null;
    }

    @Override
    public String createSelectQuery() {
        return constructSelect();
    }

    @Override
    public String createSelectUniqueQuery(final String billNum) {
        return new EnergyBillQueryFactory().constructUniqueSelect(billNum);
    }

    @Override
    public String createSelectUniqueQuery(String id, String column) {
        return null;
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
