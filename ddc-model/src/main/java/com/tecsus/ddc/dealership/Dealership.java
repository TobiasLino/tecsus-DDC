package com.tecsus.ddc.dealership;

import com.tecsus.ddc.client.Instalation;

import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author TOBIASDASILVALINO
 */
public class Dealership {

    private final Dealerships dealership;
    private final String CNPJ;
    private final URL site;
    private final Set<Instalation> instalations = new HashSet<>();

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
                ", instalations=" + instalations +
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
                Objects.equals(instalations, that.instalations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dealership, CNPJ, site, instalations);
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

    public void addInstalation(Instalation cli) {
        this.instalations.add(cli);
    }

    public Set<Instalation> getInstalations() {
        return instalations;
    }
}
