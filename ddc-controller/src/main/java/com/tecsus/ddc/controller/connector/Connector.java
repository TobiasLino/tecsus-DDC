package com.tecsus.ddc.controller.connector;

import com.tecsus.ddc.controller.config.ConnectorConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author TOBIASDASILVALINO
 */
public class Connector {

    private ConnectorConfig config;
    private Connection connection;

    private static final Logger log = LoggerFactory.getLogger(Connector.class);

    public Connector() {
        log.info("Configuring the connection");
        this.config = new ConnectorConfig();
    }

    public Connector connect() {
        log.info("Connecting to the database");
        try {
            Class.forName(config.getDriver());
            connection = DriverManager.getConnection(
                    config.getUri(),
                    config.getUsername(),
                    config.getPasswd());
            log.info("Connection Established");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            log.info("Could not connect to the database");
        }
        return this;
    }

    public void close() {
        log.info("Desconnecting to the database");
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            log.info("Connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("Could not disconnect the database");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
