package com.tecsus.ddc.controller.connector;

import com.tecsus.ddc.controller.config.ConnectorConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author TOBIASDASILVALINO
 */
public class Connector {

    private final ConnectorConfig config;
    private ConnectionImpl connection;

    private static final Logger log = LoggerFactory.getLogger(Connector.class);

    public Connector() {
        this.config = ConnectorConfig.getConfig();
    }

    public Connector connect() {
        log.info("Connecting to the database..");
        try {
            Class.forName(config.getDriver());
            log.info("Loading connection..");
            connection = new ConnectionImpl(
                    DriverManager.getConnection(
                        config.getUri(),
                        config.getUsername(),
                        config.getPasswd()
                    )
            );
            log.info("Connection Established!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            log.info("Could not connect to the database");
        }
        return this;
    }

    public void close() {
    }

    public ConnectionImpl getConnection() {
        return connection;
    }
}
