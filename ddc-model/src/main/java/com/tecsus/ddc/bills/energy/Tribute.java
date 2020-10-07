package com.tecsus.ddc.bills.energy;

import com.tecsus.ddc.bills.energy.enums.Tributes;

import java.math.BigDecimal;

public class Tribute {

    private Tributes description;
    private BigDecimal calcBase;
    private BigDecimal aliq;    // %
    private BigDecimal value;   // R$

    public Tribute(final Tributes description, final BigDecimal calcBase, final BigDecimal aliq, final BigDecimal value) {
        this.description = description;
        this.calcBase = calcBase;
        this.aliq = aliq;
        this.value = value;
    }

    public Tributes getDescription() {
        return description;
    }

    public void setDescription(final Tributes description) {
        this.description = description;
    }

    public BigDecimal getCalcBase() {
        return calcBase;
    }

    public void setCalcBase(final BigDecimal calcBase) {
        this.calcBase = calcBase;
    }

    public BigDecimal getAliq() {
        return aliq;
    }

    public void setAliq(final BigDecimal aliq) {
        this.aliq = aliq;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(final BigDecimal value) {
        this.value = value;
    }
}
