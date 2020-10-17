package com.tecsus.ddc.bills.energy.builders;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.bills.energy.Classe;
import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.Group;
import com.tecsus.ddc.bills.energy.RushHour;
import com.tecsus.ddc.bills.energy.enums.Modalities;
import com.tecsus.ddc.bills.energy.enums.SupplyType;
import org.joda.time.DateTime;

import java.math.BigDecimal;

public final class EnergyBillBuilder {
    private Bill bill;
    private DateTime emission;
    private String meterNumber;
    // Dados do Contrato
    private BigDecimal consumption;
    private int tension;     // Volts
    private Group group;    // Grupo/subgrupo
    private Classe classe;  // Classe/subclasse
    private SupplyType supplyType;

    private EnergyBillBuilder() {
    }

    public static EnergyBillBuilder anEnergyBill() {
        return new EnergyBillBuilder();
    }

    public EnergyBillBuilder bill(Bill bill) {
        this.bill = bill;
        return this;
    }

    public EnergyBillBuilder meterNumber(final String meterNumber) {
        this.meterNumber = meterNumber;
        return this;
    }

    public EnergyBillBuilder emission(DateTime emission) {
        this.emission = emission;
        return this;
    }

    public EnergyBillBuilder consumption(BigDecimal consumption) {
        this.consumption = consumption;
        return this;
    }

    public EnergyBillBuilder tension(int tension) {
        this.tension = tension;
        return this;
    }

    public EnergyBillBuilder group(Group group) {
        this.group = group;
        return this;
    }

    public EnergyBillBuilder classe(Classe classe) {
        this.classe = classe;
        return this;
    }

    public EnergyBillBuilder supplyType(SupplyType supplyType) {
        this.supplyType = supplyType;
        return this;
    }

    public EnergyBill build() {
        EnergyBill energyBill = new EnergyBill();
        energyBill.setBill(bill);
        energyBill.setMeterNumber(meterNumber);
        energyBill.setEmission(emission);
        energyBill.setConsumption(consumption);
        energyBill.setTension(tension);
        energyBill.setGroup(group);
        energyBill.setClasse(classe);
        energyBill.setSupplyType(supplyType);
        return energyBill;
    }
}
