package com.tecsus.ddc.client;

import java.util.Objects;

/**
 * @author TOBIASDASILVALINO
 */
public class Client {

    private String CNPJ;
    private String name;

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" +
                "CNPJ='" + CNPJ + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Client client = (Client) o;
        return Objects.equals(CNPJ, client.CNPJ) &&
                Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CNPJ, name);
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(final String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
