package com.tecsus.ddc.dealership.builders;

import com.tecsus.ddc.dealership.Dealership;
import com.tecsus.ddc.dealership.enums.EnergyDealerships;

import java.net.URL;

/**
 * @author TOBIASDASILVALINO
 */
public class DealershipBuilder {

    private EnergyDealerships name;
    private String CNPJ;
    private URL site;

    public Dealership build() {
        return new Dealership(name, CNPJ, site);
    }

    public DealershipBuilder name(EnergyDealerships name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        return this;
    }
}
