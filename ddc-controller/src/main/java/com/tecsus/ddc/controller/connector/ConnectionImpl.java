package com.tecsus.ddc.controller.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionImpl{

    private final Connection connection;
    private final static Logger log = LoggerFactory.getLogger(ConnectionImpl.class);

    public ConnectionImpl(final Connection connection) {
        this.connection = connection;
    }

    public Connection get() {
        return connection;
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public void close() {
        log.info("Desconnecting to the database..");
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

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
                log.info("Statement closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("Statement close failed");
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            log.info("ResultSet closed");
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("ResultSet close failed");
        }
    }
}
