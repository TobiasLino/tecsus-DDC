package com.tecsus.ddc.bills.energy.builders;

import com.tecsus.ddc.bills.energy.ConsumptionDescription;
import com.tecsus.ddc.bills.energy.EnergyBill;
import com.tecsus.ddc.bills.energy.Group;
import com.tecsus.ddc.bills.energy.RushHour;
import org.joda.time.DateTime;

/**
 * @author TOBIASDASILVALINO
 */
public class EnergyBillBuilder {

    private DateTime emission;
    private double tension;     // Volts
    private double consumption;
    private ConsumptionDescription consumptionDescription;
    private Group group;    // Grupo/subgrupo classe/subclasse
    private RushHour rushHour;  // apenas para grupo A industrial

    public EnergyBill build() {
        return new EnergyBill(emission, tension, consumption, consumptionDescription, group, rushHour);
    }

    public void emission(final DateTime emission) {
        this.emission = emission;
    }

    public void tension(final double tension) {
        this.tension = tension;
    }

    public void consumption(final double consumption) {
        this.consumption = consumption;
    }

    public void consumptionDescription(final ConsumptionDescription consumptionDescription) {
        this.consumptionDescription = consumptionDescription;
    }

    public void group(final Group group) {
        this.group = group;
    }

    public void rushHour(final RushHour rushHour) {
        this.rushHour = rushHour;
    }
}
