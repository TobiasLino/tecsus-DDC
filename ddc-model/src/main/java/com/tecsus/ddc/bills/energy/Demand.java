package com.tecsus.ddc.bills.energy;

/*
 *  @author Tobias Lino
 */
public class Demand {

    private double demandaPonta;
    private double demandaForaPonta;

    public Demand(final double demandaPonta, final double demandaForaPonta) {
        this.demandaPonta = demandaPonta;
        this.demandaForaPonta = demandaForaPonta;
    }

    public double getDemandaPonta() {
        return demandaPonta;
    }

    public void setDemandaPonta(final double demandaPonta) {
        this.demandaPonta = demandaPonta;
    }

    public double getDemandaForaPonta() {
        return demandaForaPonta;
    }

    public void setDemandaForaPonta(final double demandaForaPonta) {
        this.demandaForaPonta = demandaForaPonta;
    }
}
