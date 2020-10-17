package com.tecsus.ddc.dealership;

import com.tecsus.ddc.client.Instalation;

import java.net.URL;
import java.util.*;

/**
 * @author TOBIASDASILVALINO
 */
public class Dealership {

    private int id;
    private String initials;
    private String CNPJ;
    private String site;
    private List<Instalation> instalations;

    public Dealership() {
        this.instalations = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "id=" + id +
                ", initials='" + initials + '\'' +
                ", CNPJ='" + CNPJ + '\'' +
                ", site='" + site + '\'' +
                ", instalations=" + instalations +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Dealership that = (Dealership) o;
        return id == that.id &&
                Objects.equals(initials, that.initials) &&
                Objects.equals(CNPJ, that.CNPJ) &&
                Objects.equals(site, that.site) &&
                Objects.equals(instalations, that.instalations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, initials, CNPJ, site, instalations);
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(final String initials) {
        this.initials = initials;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(final String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getSite() {
        return site;
    }

    public void setSite(final String site) {
        this.site = site;
    }

    public List<Instalation> getInstalations() {
        return instalations;
    }

    public void addInstalations(Instalation instalation) {
        this.instalations.add(instalation);
    }
}
