package com.andersenlab.web_user_tracker.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBCPDataSource {
    private final static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://192.168.1.5:5432/user-tracker");
        ds.setUsername("postgres");
        ds.setPassword("s585");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private DBCPDataSource() {
    }
}

