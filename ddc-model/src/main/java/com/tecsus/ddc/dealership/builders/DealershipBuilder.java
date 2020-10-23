package com.tecsus.ddc.dealership.builders;

import com.tecsus.ddc.dealership.Dealership;

public final class DealershipBuilder {
    private Dealership dealership;

    private DealershipBuilder() {
        dealership = new Dealership();
    }

    public static DealershipBuilder aDealership() {
        return new DealershipBuilder();
    }

    public DealershipBuilder id(int id) {
        dealership.setId(id);
        return this;
    }

    public DealershipBuilder initials(String initials) {
        dealership.setInitials(initials);
        return this;
    }

    public DealershipBuilder CNPJ(String CNPJ) {
        dealership.setCNPJ(CNPJ);
        return this;
    }

    public DealershipBuilder site(String site) {
        dealership.setSite(site);
        return this;
    }

    public Dealership build() {
        return dealership;
    }
}
