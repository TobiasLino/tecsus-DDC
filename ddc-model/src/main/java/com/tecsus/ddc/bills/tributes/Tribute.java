package com.tecsus.ddc.bills.tributes;

import java.math.BigDecimal;
import java.util.Objects;

public class Tribute {

    private Tributes description;
    private BigDecimal calcBase;
    private BigDecimal aliq;    // %
    private BigDecimal value;   // R$

    public Tribute() {
    }

    public Tribute(
            final Tributes description,
            final BigDecimal calcBase,
            final BigDecimal aliq,
            final BigDecimal value) {
        this.description = description;
        this.calcBase = calcBase;
        this.aliq = aliq;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tribute{" +
                "description=" + description +
                ", calcBase=" + getCalcBase() +
                ", aliq=" + getAliq() +
                ", value=" + getValue() +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Tribute tribute = (Tribute) o;
        return description == tribute.description &&
                Objects.equals(calcBase, tribute.calcBase) &&
                Objects.equals(aliq, tribute.aliq) &&
                Objects.equals(value, tribute.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, calcBase, aliq, value);
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
        return value.setScale(2, BigDecimal.ROUND_FLOOR);
    }

    public void setValue(final BigDecimal value) {
        this.value = value;
    }
}
