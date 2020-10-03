package com.tecsus.ddc.bills.energy;

/*
 *  @author Tobias Lino
 */
import com.tecsus.ddc.bills.energy.enums.TariffFlags;
import org.joda.time.DateTime;

public class EnergyBill {

    private DateTime emission;
    private double tension;     // Volts
    private ConsumptionDescription consumptionDescription;
    private Group group;    // Grupo/subgrupo classe/subclasse
    private Demand demand;    // apenas grupo A
    private RushHour rushHour;  // apenas para grupo A industrial
    private TariffFlags tariffFlag;

    public TariffFlags getTariffFlag() {
        return tariffFlag;
    }

    public void setTariffFlag(TariffFlags tariffFlag) {
        this.tariffFlag = tariffFlag;
    }
}
