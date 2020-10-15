package com.tecsus.ddc.dealership.enums;

import com.tecsus.ddc.dealership.Dealerships;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author TOBIASDASILVALINO
 */
public enum WaterDealerships implements Dealerships {
    SABESP("SABESP Companhia de Saneamento Básico do Estado de São Paulo", "43.776.517/0001-80", "https://www.sabesp.com.br");

    private String dealership;
    private String CNPJ;
    private URL site;

    WaterDealerships(String dealership, String CNPJ, String site) {
        try {
            this.dealership = dealership;
            this.CNPJ = CNPJ;
            this.site = new URL(site);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getDescription() {
        return dealership;
    }

    @Override
    public String getCNPJ() {
        return CNPJ;
    }

    @Override
    public URL getSite() {
        return site;
    }
}
