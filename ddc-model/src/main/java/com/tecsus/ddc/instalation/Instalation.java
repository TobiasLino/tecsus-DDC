package com.tecsus.ddc.instalation;

import com.tecsus.ddc.client.Client;
import com.tecsus.ddc.dealership.Dealership;

import java.util.Objects;

/**
 * @author TOBIASDASILVALINO
 */
public class Instalation {

    private String numInst;
    private Address address;
    private Client client;
    private Dealership dealership;

    public Instalation() {
    }

    @Override
    public String toString() {
        return "Instalation{" +
                "numInst='" + numInst + '\'' +
                ", address=" + address +
                ", client=" + client +
                ", dealership=" + dealership +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Instalation that = (Instalation) o;
        return Objects.equals(numInst, that.numInst) &&
                Objects.equals(address, that.address) &&
                Objects.equals(client, that.client) &&
                Objects.equals(dealership, that.dealership);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numInst, address, client, dealership);
    }

    public String getNumInst() {
        return numInst;
    }

    public void setNumInst(final String numInst) {
        this.numInst = numInst;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(final Client client) {
        this.client = client;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(final Dealership dealership) {
        this.dealership = dealership;
    }
}
