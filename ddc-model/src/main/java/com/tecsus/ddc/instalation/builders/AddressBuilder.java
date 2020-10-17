package com.tecsus.ddc.instalation.builders;

import com.tecsus.ddc.instalation.Address;

public final class AddressBuilder {
    private Address address;

    private AddressBuilder() {
        address = new Address();
    }

    public static AddressBuilder anAddress() {
        return new AddressBuilder();
    }

    public AddressBuilder zip(String zip) {
        address.setZip(zip);
        return this;
    }

    public AddressBuilder street(String street) {
        address.setStreet(street);
        return this;
    }

    public AddressBuilder num(String num) {
        address.setNum(num);
        return this;
    }

    public AddressBuilder complement(String complement) {
        address.setComplement(complement);
        return this;
    }

    public AddressBuilder neighborhood(String neighborhood) {
        address.setNeighborhood(neighborhood);
        return this;
    }

    public AddressBuilder city(String city) {
        address.setCity(city);
        return this;
    }

    public AddressBuilder uf(String uf) {
        address.setUf(uf);
        return this;
    }

    public Address build() {
        return address;
    }
}
