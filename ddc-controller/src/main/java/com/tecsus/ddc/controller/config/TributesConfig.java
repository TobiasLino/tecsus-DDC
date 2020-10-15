package com.tecsus.ddc.controller.config;

import com.tecsus.ddc.bills.tributes.Tributes;
import com.tecsus.ddc.utils.PropertiesLoaderImpl;

/**
 * @author TOBIASDASILVALINO
 */
public class TributesConfig {

    private final PropertiesLoaderImpl loader;
    private final Tributes tributeType;

    public TributesConfig(Tributes tribute) {
        loader = new PropertiesLoaderImpl(Properties.TRIBUTES.getPropertiesFileName());
        this.tributeType = tribute;
    }

    public String getURL() {
        return loader.getProperty(tributeType.name() + ".url");
    }
}
