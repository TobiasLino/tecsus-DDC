package com.tecsus.ddc.bills.energy;

/*
 * @author Tobias Lino
 */
public class ConsumptionDescription {

    private long meterNumber;
    private double previousReading;
    private double actualReading;
    private double constMult;
    private double kWhQuantityPerMonth;

    public ConsumptionDescription(
            final long meterNumber,
            final double previousReading,
            final double actualReading,
            final double constMult,
            final double kWhQuantityPerMonth) {
        this.meterNumber = meterNumber;
        this.previousReading = previousReading;
        this.actualReading = actualReading;
        this.constMult = constMult;
        this.kWhQuantityPerMonth = kWhQuantityPerMonth;
    }

    @Override
    public String toString() {
        return "ConsumptionDescription{" +
                "meterNumber=" + meterNumber +
                ", previousReading=" + previousReading +
                ", actualReading=" + actualReading +
                ", constMult=" + constMult +
                ", kWhQuantityPerMonth=" + kWhQuantityPerMonth +
                '}';
    }

    public long getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(final long meterNumber) {
        this.meterNumber = meterNumber;
    }

    public double getPreviousReading() {
        return previousReading;
    }

    public void setPreviousReading(final double previousReading) {
        this.previousReading = previousReading;
    }

    public double getActualReading() {
        return actualReading;
    }

    public void setActualReading(final double actualReading) {
        this.actualReading = actualReading;
    }

    public double getConstMult() {
        return constMult;
    }

    public void setConstMult(final double constMult) {
        this.constMult = constMult;
    }

    public double getkWhQuantityPerMonth() {
        return kWhQuantityPerMonth;
    }

    public void setkWhQuantityPerMonth(final double kWhQuantityPerMonth) {
        this.kWhQuantityPerMonth = kWhQuantityPerMonth;
    }
}
