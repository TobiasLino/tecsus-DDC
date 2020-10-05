package com.tecsus.ddc.bills.utils;

public class Propertiesimpl {

    private PropertiesLoader loader;

    public Propertiesimpl(String fileName) {
        loader = new PropertiesLoader(fileName);
    }

    public String getProperty(String key) {
        return loader.getProperty(key);
    }
}
