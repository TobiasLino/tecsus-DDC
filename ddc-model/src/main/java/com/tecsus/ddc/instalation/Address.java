package com.tecsus.ddc.instalation;

import java.util.Objects;

/**
 * @author TOBIASDASILVALINO
 */
public class Address {

    private String zip;
    private String street;
    private String num;
    private String complement;
    private String neighborhood;
    private String city;
    private String uf;

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "zip='" + zip + '\'' +
                ", street='" + street + '\'' +
                ", num='" + num + '\'' +
                ", complement='" + complement + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Address address = (Address) o;
        return Objects.equals(zip, address.zip) &&
                Objects.equals(street, address.street) &&
                Objects.equals(num, address.num) &&
                Objects.equals(complement, address.complement) &&
                Objects.equals(neighborhood, address.neighborhood) &&
                Objects.equals(city, address.city) &&
                Objects.equals(uf, address.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zip, street, num, complement, neighborhood, city, uf);
    }

    public String getZip() {
        return zip;
    }

    public void setZip(final String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getNum() {
        return num;
    }

    public void setNum(final String num) {
        this.num = num;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(final String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(final String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(final String uf) {
        this.uf = uf;
    }
}
