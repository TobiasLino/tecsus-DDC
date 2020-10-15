package com.tecsus.ddc.utils.query;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.tributes.Tribute;
import com.tecsus.ddc.bills.tributes.Tributes;

import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
public class EnergyBillQuery implements QueryConstructor {

    private String query;

    @Override
    public QueryConstructor insert() {
        this.query += "INSERT INTO ";
        return this;
    }

    @Override
    public QueryConstructor table(final String table) {
        this.query += table;
        return this;
    }

    @Override
    public <T> String values(T bill) {
        if (!(bill instanceof EnergyBill)) {
            throw new IllegalArgumentException("The Argument isn't a energy bill");
        }
        EnergyBill energyBill = (EnergyBill) bill;
        Optional<Tribute> icms = energyBill.getTribute(Tributes.ICMS);

        query += fields() + " VALUES (";

        query += "'"
                + energyBill.getConsumption().toString() + "', '"
                + energyBill.getTension().toString() + "', "
                + energyBill.getEmission() + "', '" // todo: adicionar os TO_DATE()
                + (icms.isPresent() ? icms.get().getValue() : "''") + ", "
                + energyBill.getTributesTotal().toString()
                + energyBill.getFinancialItemsTotal().toString();
        query += ");";

        return query;
    }

    private String fields() {
        return " ("
                + "abs_bill, "
                + "consum_kwh, "
                + "tension, "
                + "emission, "
                + "icms, "
                + "tributes, "
                + "financ_items, "
                + "supply, "
                + "en_group, "
                + "en_sub_group, "
                + "en_class, "
                + "en_sub_class, "
                + "en_modalitie" + ") ";
    }

    @Override
    public QueryConstructor select() {

        return this;
    }
}
