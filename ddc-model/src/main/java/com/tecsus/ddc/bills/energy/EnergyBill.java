package com.tecsus.ddc.bills.energy;

/*
 *  @author Tobias Lino
 */
import com.tecsus.ddc.bills.energy.enums.TariffFlags;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EnergyBill {

    private DateTime emission;
    private double tension;     // Volts
    private ConsumptionDescription consumptionDescription;
    private Group group;    // Grupo/subgrupo classe/subclasse
    private RushHour rushHour;  // apenas para grupo A industrial
    private List<TariffFlag> tariffFlags = new ArrayList<>();

    public List<TariffFlag> getTariffFlags() {
        return tariffFlags;
    }

    public List<TariffFlag> getTariffFlag(TariffFlags flag) {
        if (tariffFlags.isEmpty()) {
            return null;
        }
        return tariffFlags.stream()
                .filter(f -> f.getFlag().equals(flag))
                .collect(Collectors.toList());
    }

    public void addTariffFlag(TariffFlag tariffFlag) {
        this.tariffFlags.add(tariffFlag);
    }
}
