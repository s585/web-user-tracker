//package com.andersenlab.web_user_tracker.jdbc;
//
//import com.andersenlab.web_user_tracker.exception.DataBaseConnectionException;
//import org.postgresql.ds.PGSimpleDataSource;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//
//public class DataBaseConnection {
//    private PGSimpleDataSource ds;
//
//    private final String USER_NAME = "postgres";
//    private final String PASSWORD = "s585";
//    private final String DB_URL = "jdbc:postgresql://192.168.1.5:5432/user_tracker";
//
//    public DataBaseConnection() {
//        ds = new PGSimpleDataSource();
//    }
//
//    private void configureDS() {
//        ds.setURL(DB_URL);
//        ds.setUser(USER_NAME);
//        ds.setPassword(PASSWORD);
//    }
//
//    public Connection getConnection() {
//        configureDS();
//        Connection conn = null;
//        try {
//            conn = ds.getConnection();
//        } catch (SQLException e) {
//            throw new DataBaseConnectionException(e);
//        } finally {
//            return conn;
//        }
//    }
//}
