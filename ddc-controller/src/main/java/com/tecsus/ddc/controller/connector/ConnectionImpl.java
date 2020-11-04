package com.tecsus.ddc.controller.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class ConnectionImpl{

    private final Connection connection;
    private final static Logger log = LoggerFactory.getLogger(ConnectionImpl.class);

    public ConnectionImpl(final Connection connection) {
        this.connection = connection;
    }

    public static ConnectionImpl create(final Connection connection) {
        return new ConnectionImpl(connection);
    }

    public Connection get() {
        return connection;
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public void executeInsert(final String query) {
        try {
            log.debug(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            log.info("Inserted.");
        } catch (SQLException e) {
            log.error("Insert failed");
            e.printStackTrace();
        }
    }

    public Optional<ResultSet> executeSelect(final String query) {
        Statement statement = null;
        try {
            log.debug(query);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet != null && resultSet.next()) {
                return Optional.of(resultSet);
            }
            log.info("Select success.");
        } catch (SQLException e) {
            log.error("Select Failed.");
            e.printStackTrace();
        }
        return Optional.empty();
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
