package com.tecsus.ddc.controller.connector;

import com.tecsus.ddc.bills.utils.PropertiesLoaderImpl;

/**
 * @author TOBIASDASILVALINO
 */
public class ConnectorConfig {

    private final String PROPERTIES = "database-connection.properties";

    private String host;
    private String name;
    private String port;
    private String uri;
    private String driver;
    private String username;
    private String passwd;

    public ConnectorConfig() {
        PropertiesLoaderImpl loader = new PropertiesLoaderImpl(PROPERTIES);

        this.host = loader.getProperty("database.host");
        this.name = loader.getProperty("database.name");
        this.port = loader.getProperty("database.port");
        this.uri = loader.getProperty("database.uri");
        this.driver = loader.getProperty("database.driver");
        this.username = loader.getProperty("database.user.username");
        this.passwd = loader.getProperty("database.user.password");
    }

    public String getHost() {
        return host;
    }

    public String getName() {
        return name;
    }

    public String getPort() {
        return port;
    }

    public String getUri() {
        return uri;
    }

    public String getDriver() {
        return driver;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return passwd;
    }
}
