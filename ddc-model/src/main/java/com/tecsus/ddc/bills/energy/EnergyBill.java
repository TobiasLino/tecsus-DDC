package com.tecsus.ddc.bills.energy;

/*
 *  @author Tobias Lino
 */
import org.joda.time.DateTime;

public class EnergyBill {

    private DateTime emission;
    private double tension;     // Volts
    private ConsumptionDescription consumptionDescription;
    private Group group;    // Grupo/subgrupo classe/subclasse
    private Demand demand;    // apenas grupo A
    private RushHour rushHour;  // apenas para grupo A industrial
}
