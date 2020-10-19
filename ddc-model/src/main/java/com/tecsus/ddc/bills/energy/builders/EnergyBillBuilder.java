package com.tecsus.ddc.bills.energy.builders;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.energy.Classe;
import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.Group;
import com.tecsus.ddc.bills.energy.enums.SupplyType;
import org.joda.time.DateTime;

import java.math.BigDecimal;

public final class EnergyBillBuilder {
    private EnergyBill energyBill;

    private EnergyBillBuilder() {
        energyBill = new EnergyBill();
    }

    public static EnergyBillBuilder anEnergyBill() {
        return new EnergyBillBuilder();
    }

    public EnergyBillBuilder id(final int id) {
        energyBill.setId(id);
        return this;
    }

    public EnergyBillBuilder bill(Bill bill) {
        energyBill.setBill(bill);
        return this;
    }

    public EnergyBillBuilder emission(DateTime emission) {
        energyBill.setEmission(emission);
        return this;
    }

    public EnergyBillBuilder consumption(BigDecimal consumption) {
        energyBill.setConsumption(consumption);
        return this;
    }

    public EnergyBillBuilder tension(int tension) {
        energyBill.setTension(tension);
        return this;
    }

    public EnergyBillBuilder group(Group group) {
        energyBill.setGroup(group);
        return this;
    }

    public EnergyBillBuilder classe(Classe classe) {
        energyBill.setClasse(classe);
        return this;
    }

    public EnergyBillBuilder supplyType(SupplyType supplyType) {
        energyBill.setSupplyType(supplyType);
        return this;
    }

    public EnergyBillBuilder financialItems(BigDecimal financialItems) {
        energyBill.setFinancialItems(financialItems);
        return this;
    }

    public EnergyBill build() {
        return energyBill;
    }
}
