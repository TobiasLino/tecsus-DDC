package com.tecsus.ddc.controller.config;

import com.tecsus.ddc.utils.PropertiesLoader;
/**
 * @author TOBIASDASILVALINO
 */
public enum Properties {
    CONNECTOR("database-connection.properties"),
    TRIBUTES("tributes.properties");

    private String propertiesFileName;

    Properties(final String propertiesFileName) {
        this.propertiesFileName = propertiesFileName;
    }

    public String getPropertiesFileName() {
        return propertiesFileName;
    }
}
