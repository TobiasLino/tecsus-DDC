package com.tecsus.ddc.controller.config;

import com.tecsus.ddc.utils.PropertiesLoaderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author TOBIASDASILVALINO
 */
public class ConnectorConfig {

    private final String host;
    private final String name;
    private final String port;
    private final String uri;
    private final String driver;
    private final String username;
    private final String passwd;

    private static final Logger log = LoggerFactory.getLogger(ConnectorConfig.class);

    public ConnectorConfig() {
        log.info("Loading configurations");
        final PropertiesLoaderImpl loader = new PropertiesLoaderImpl(Properties.CONNECTOR.getPropertiesFileName());

        this.host = loader.getProperty("database.host");
        this.name = loader.getProperty("database.name");
        this.port = loader.getProperty("database.port");
        this.uri = loader.getProperty("database.uri");
        this.driver = loader.getProperty("database.driver");
        this.username = loader.getProperty("database.user.username");
        this.passwd = loader.getProperty("database.user.password");
        log.info("Configurations loaded");
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
