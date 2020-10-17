package com.tecsus.ddc.instalation.builders;

import com.tecsus.ddc.client.Client;
import com.tecsus.ddc.dealership.Dealership;
import com.tecsus.ddc.instalation.Address;
import com.tecsus.ddc.instalation.Instalation;

public final class InstalationBuilder {
    private Instalation instalation;

    private InstalationBuilder() {
        instalation = new Instalation();
    }

    public static InstalationBuilder anInstalation() {
        return new InstalationBuilder();
    }

    public InstalationBuilder numInst(String numInst) {
        instalation.setNumInst(numInst);
        return this;
    }

    public InstalationBuilder address(Address address) {
        instalation.setAddress(address);
        return this;
    }

    public InstalationBuilder client(Client client) {
        instalation.setClient(client);
        return this;
    }

    public InstalationBuilder dealership(Dealership dealership) {
        instalation.setDealership(dealership);
        return this;
    }

    public Instalation build() {
        return instalation;
    }
}
