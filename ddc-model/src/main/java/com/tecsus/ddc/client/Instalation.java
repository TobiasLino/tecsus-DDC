package com.tecsus.ddc.client;

import java.util.Objects;

/**
 * @author TOBIASDASILVALINO
 */
public class Instalation {

    private long instalationCode;
    private Address address;

    public Instalation(long instalationCode, Address address) {
        this.instalationCode = instalationCode;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Instalation{" +
                "instalationCode=" + instalationCode +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instalation that = (Instalation) o;
        return instalationCode == that.instalationCode &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instalationCode, address);
    }

    public long getInstalationCode() {
        return instalationCode;
    }

    public void setInstalationCode(long instalationCode) {
        this.instalationCode = instalationCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
