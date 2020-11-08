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
        return new EnergyBillQueryBuilder(bill).constructInsert(bill);
    }

    public static String getSelectQuery() {
        return new EnergyBillQueryBuilder().constructSelect();
    }

    public static String getSelectUniqueQuery(final String billNum) {
        return new EnergyBillQueryBuilder().constructUniqueSelect(billNum);
    }
    private <S extends EnergyBill> String constructInsert(final S bill) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        return "INSERT INTO energy_bill  ( "+
                "abs_bill, consum_khw, tension, emission, icms, tributes, financ_items, supply, en_group, "+
                "en_sub_group, en_class, en_sub_class, en_modalitie) VALUES (" + "'" +
                bill.getBill().getNumConta() + "','" +
                bill.getConsumption().toString() + "', " +
                bill.getTension() + ", " +
                "TO_DATE('" + date.format(bill.getEmission().toDate()) + "', 'YYYY/MM/DD'),' " +
                bill.getIcms().toString() + "', '" +
                bill.getTributes().toString() + "', '" +
                bill.getFinancialItems().toString() + "', '" +
                bill.getSupplyType().name() + "', '" +
                bill.getGroup().getGroup().name() + "', '" +
                bill.getGroup().getSubGroup().name() + "', '" +
                bill.getClasse().getClasse().name() + "', '" +
                bill.getClasse().getSubClasses().name() + "', '" +
                bill.getModalitie().name() + "' )";
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
    public String constructFlagSelect(final Integer idEnergy){
        return "SELECT eb.abs_bill, efc.flag_color, efc.start_date, efc.finish_date " +
                "FROM energy_bill eb INNER JOIN energy_flag_ctrl efc " +
                "ON eb.id_energy_type = efc.id_energy_bill " +
                "WHERE eb.id_energy_type = " + idEnergy;
    }
    public String constructProductSelect(final Integer idEnergy){
        return "SELECT eb.id_energy_type, ep.kwh_quant, ep.total_val, ep.supply_val, ep.prod_desc, ept.cci " +
                "FROM energy_bill eb inner join energy_product ep ON " +
                "eb.id_energy_type = ep.bill_num INNER JOIN energy_product_type ept on " +
                "ep.prod_desc = ept.descript"+
                "WHERE eb.id_energy_type = " + idEnergy;
    }
}