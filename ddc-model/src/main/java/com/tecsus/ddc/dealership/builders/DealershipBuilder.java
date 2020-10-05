package com.tecsus.ddc.dealership.builders;

import com.tecsus.ddc.client.Client;
import com.tecsus.ddc.dealership.Dealership;
import com.tecsus.ddc.dealership.enums.Dealerships;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class DealershipBuilder {

    private Dealerships dealership;
    private String CNPJ;
    private URL site;

    public Dealership build() {
        return new Dealership(dealership, CNPJ, site);
    }

    public DealershipBuilder dealership(Dealerships name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.dealership = name;
        return this;
    }
}
