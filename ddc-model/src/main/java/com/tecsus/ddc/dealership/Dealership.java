package com.tecsus.ddc.dealership;

import java.util.*;

/**
 * @author TOBIASDASILVALINO
 */
public class Dealership {

    private int id;
    private String initials;
    private String CNPJ;
    private String site;

    public Dealership() {
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "id=" + id +
                ", initials='" + initials + '\'' +
                ", CNPJ='" + CNPJ + '\'' +
                ", site='" + site + '\'' +
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
                Objects.equals(site, that.site);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, initials, CNPJ, site);
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
}
