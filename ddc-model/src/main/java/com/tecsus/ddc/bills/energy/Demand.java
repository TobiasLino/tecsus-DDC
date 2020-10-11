package com.tecsus.ddc.bills.energy;

import java.math.BigDecimal;
/*
 *  @author Tobias Lino
 */
public class Demand {

    private BigDecimal demandaPonta;
    private BigDecimal demandaForaPonta;

    public Demand(final BigDecimal demandaPonta, final BigDecimal demandaForaPonta) {
        this.demandaPonta = demandaPonta;
        this.demandaForaPonta = demandaForaPonta;
    }

    public BigDecimal getDemandaPonta() {
        return demandaPonta;
    }

    public void setDemandaPonta(final BigDecimal demandaPonta) {
        this.demandaPonta = demandaPonta;
    }

    public BigDecimal getDemandaForaPonta() {
        return demandaForaPonta;
    }

    public void setDemandaForaPonta(final BigDecimal demandaForaPonta) {
        this.demandaForaPonta = demandaForaPonta;
    }
}
