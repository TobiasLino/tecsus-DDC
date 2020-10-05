package com.tecsus.ddc.dealership;

import com.tecsus.ddc.client.Client;
import com.tecsus.ddc.dealership.enums.Dealerships;

import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Dealership {

    private final Dealerships dealership;
    private final String CNPJ;
    private final URL site;
    private final Set<Client> clients = new HashSet<>();

    public Dealership(final Dealerships dealership, final String CNPJ, final URL site) {
        this.dealership = dealership;
        this.CNPJ = dealership.getCNPJ();
        this.site = dealership.getSite();
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "dealership=" + dealership +
                ", CNPJ='" + CNPJ + '\'' +
                ", site=" + site +
                ", clients=" + clients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dealership that = (Dealership) o;
        return dealership == that.dealership &&
                Objects.equals(CNPJ, that.CNPJ) &&
                Objects.equals(site, that.site) &&
                Objects.equals(clients, that.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dealership, CNPJ, site, clients);
    }

    public Dealerships getDealership() {
        return dealership;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public URL getSite() {
        return site;
    }

    public void addClient(Client cli) {
        this.clients.add(cli);
    }

    public Set<Client> getClients() {
        return clients;
    }
}
