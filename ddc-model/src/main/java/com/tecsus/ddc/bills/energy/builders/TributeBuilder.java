package com.tecsus.ddc.bills.energy.builders;

import com.tecsus.ddc.bills.tributes.Tribute;
import com.tecsus.ddc.bills.tributes.Tributes;

import java.math.BigDecimal;

/**
 * @author TOBIASDASILVALINO 
 */
public class TributeBuilder {
    
    private Tribute tribute;
    
    public TributeBuilder() {
        tribute = new Tribute();
    }

    public Tribute build() {
        return tribute;
    }

    public TributeBuilder description(final Tributes description) {
        this.tribute.setDescription(description);
        return this;
    }

    public TributeBuilder calcBase(final String calcBase) {
        this.tribute.setCalcBase(new BigDecimal(calcBase));
        return this;
    }

    public TributeBuilder aliq(final String aliq) {
        this.tribute.setAliq(new BigDecimal(aliq));
        return this;
    }

    public TributeBuilder value(final String value) {
        this.tribute.setValue(new BigDecimal(value));
        return this;
    }
}
