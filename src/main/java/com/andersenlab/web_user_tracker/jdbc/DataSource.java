//package com.andersenlab.web_user_tracker.jdbc;
//
//import com.andersenlab.web_user_tracker.exception.DataBaseConnectionException;
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class DataSource {
//
//    private static HikariConfig config = new HikariConfig();
//    private static HikariDataSource ds;
//
//    static {
//        config.setJdbcUrl( "jdbc:postgresql://192.168.1.5:5432/user-tracker" );
//        config.setUsername( "postgres" );
//        config.setPassword( "s585" );
//        config.addDataSourceProperty( "cachePrepStmts" , "true" );
//        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
//        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
//        ds = new HikariDataSource( config );
//    }
//
//    private DataSource() {}
//
//    public static Connection getConnection()  {
//        try {
//            return ds.getConnection();
//        } catch (SQLException e) {
//            throw new DataBaseConnectionException(e);
//        }
//    }
//}
