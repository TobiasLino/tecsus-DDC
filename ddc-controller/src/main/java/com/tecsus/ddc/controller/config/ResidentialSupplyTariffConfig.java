package com.tecsus.ddc.controller.config;

import com.tecsus.ddc.utils.PropertiesLoaderImpl;

/**
 * @author TOBIASDASILVALINO
 */
public class ResidentialSupplyTariffConfig {

    private final PropertiesLoaderImpl loader;
    private final String url;

    public ResidentialSupplyTariffConfig() {
        this.loader = new PropertiesLoaderImpl("./tariffs.properties");
        this.url = constructUrl();
    }

    private String constructUrl() {
        return loader.getProperty("residential.tariffs.url");
    }

    public String getUrl() {
        return url;
    }
}
