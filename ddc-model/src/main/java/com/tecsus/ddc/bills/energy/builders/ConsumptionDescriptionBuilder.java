package com.tecsus.ddc.bills.energy.builders;

import com.tecsus.ddc.bills.energy.ConsumptionDescription;

/*
 * @author Tobias Lino
 */
public class ConsumptionDescriptionBuilder {

    private long meterNumber;
    private double previousReading;
    private double actualReading;
    private double constMult;
    private double kWhQuantityPerMonth;

    public ConsumptionDescription build() {
        return new ConsumptionDescription(
                meterNumber,
                previousReading,
                actualReading,
                constMult,
                kWhQuantityPerMonth);
    }

    public void meterNumber(final long meterNumber) {
        this.meterNumber = meterNumber;
    }

    public ConsumptionDescriptionBuilder previousReading(final double previousReading) {
        this.previousReading = previousReading;
        return this;
    }

    public ConsumptionDescriptionBuilder actualReading(final double actualReading) {
        this.actualReading = actualReading;
        return this;
    }

    public ConsumptionDescriptionBuilder constMult(final double constMult) {
        this.constMult = constMult;
        return this;
    }

    public ConsumptionDescriptionBuilder kWhQuantityPerMonth(final double kWhQuantityPerMonth) {
        this.kWhQuantityPerMonth = kWhQuantityPerMonth;
        return this;
    }
}
