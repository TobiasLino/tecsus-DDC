package com.tecsus.ddc.bills.utils;

public class PropertiesLoaderImpl {

    private PropertiesLoader loader;

    public PropertiesLoaderImpl(String fileName) {
        loader = new PropertiesLoader(fileName);
    }

    public String getProperty(String key) {
        return loader.getProperty(key);
    }
}
