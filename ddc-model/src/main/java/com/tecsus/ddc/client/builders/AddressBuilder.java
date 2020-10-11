package com.tecsus.ddc.client.builders;

import com.tecsus.ddc.client.Address;
import com.tecsus.ddc.client.enums.State;

/**
 * @author TOBIASDASILVALINO
 */
public class AddressBuilder {

    private String zip;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private State uf;

    public Address build() {
        return new Address(
                zip,
                street,
                number,
                complement,
                neighborhood,
                city,
                uf);
    }

    public AddressBuilder zip(String zip) {
        this.zip = zip;
        return this;
    }

    public AddressBuilder street(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder number(String number) {
        this.number = number;
        return this;
    }

    public AddressBuilder complement(String complement) {
        this.complement = complement;
        return this;
    }

    public AddressBuilder neighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
        return this;
    }

    public AddressBuilder city(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder uf(State uf) {
        this.uf = uf;
        return this;
    }
}
