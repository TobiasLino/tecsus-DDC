package com.tecsus.ddc.client;

import java.util.List;
import java.util.Objects;

/**
 * @author TOBIASDASILVALINO
 */
public class Client {

    private String CNPJ;
    private String companyName;
    private List<Instalation> instalations;

    public Client(
            final String CNPJ,
            final String companyName,
            final List<Instalation> instalations) {
        this.CNPJ = CNPJ;
        this.companyName = companyName;
        this.instalations = instalations;
    }

    @Override
    public String toString() {
        return "Client{" +
                "CNPJ='" + CNPJ + '\'' +
                ", companyName='" + companyName + '\'' +
                ", instalations=[" + instalations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(CNPJ, client.CNPJ) &&
                Objects.equals(companyName, client.companyName) &&
                Objects.equals(instalations, client.instalations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CNPJ, companyName, instalations);
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Instalation> getInstalations() {
        return instalations;
    }

    public void addInstalation(Instalation instalation) {
        if (instalation == null) {
            throw new NullPointerException();
        }
        this.instalations.add(instalation);
    }
}
