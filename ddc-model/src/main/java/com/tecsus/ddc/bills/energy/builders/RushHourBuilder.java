package com.tecsus.ddc.bills.energy.builders;

import java.util.Calendar;

/*
 *  @author Tobias Lino
 */
public class RushHourBuilder {
    private int hours;
    private int minutes;
    private int seconds;

    public Calendar build() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.SECOND, seconds);
        return cal;
    }

    public EnergyBillRushHourBuilder  setHours(final int hours) {
        this.hours = hours;
        return this;
    }

    public EnergyBillRushHourBuilder  setMinutes(final int minutes) {
        this.minutes = minutes;
        return this;
    }

    public EnergyBillRushHourBuilder  setSeconds(final int seconds) {
        this.seconds = seconds;
        return this;
    }
}
