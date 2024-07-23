package com.example.demo.sistema;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *  class to hold JDBC connection parameters and create a method to get database Connection
 */
public class DBConnectionProvider {

    private final String url;
    private final String username;
    private final String password;

    public DBConnectionProvider(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
