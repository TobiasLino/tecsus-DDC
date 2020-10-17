package com.tecsus.ddc.dealership.enums;

import com.tecsus.ddc.dealership.Dealerships;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author TOBIASDASILVALINO
 */
public enum EnergyDealerships implements Dealerships {
    EDP_SP("EDP São Paulo Distribuição de Energia S.A.", "02.302.100/0001-06", "https://www.edponline.com.br");

    private String dealership;
    private String CNPJ;
    private URL site;

    EnergyDealerships(String dealership, String CNPJ, String site) {
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
