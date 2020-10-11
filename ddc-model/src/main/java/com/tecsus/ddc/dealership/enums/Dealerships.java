package com.tecsus.ddc.dealership.enums;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author TOBIASDASILVALINO
 */
public enum Dealerships {
    EDPSP("EDP São Paulo Distribuição de Energia S.A.", "02.302.100/0001-06", "https://www.edponline.com.br"),
    SABESP("SABESP Companhia de Saneamento Básico do Estado de São Paulo", "43.776.517/0001-80", "https://www.sabesp.com.br");

    private String dealership;
    private String CNPJ;
    private URL site;

    Dealerships(String dealership, String CNPJ, String site) {
        try {
            this.dealership = dealership;
            this.CNPJ = CNPJ;
            this.site = new URL(site);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String getDealership() {
        return dealership;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public URL getSite() {
        return site;
    }
}
