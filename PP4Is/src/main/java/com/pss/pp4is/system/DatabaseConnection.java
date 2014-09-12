/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pss.pp4is.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nedzad
 */
public class DatabaseConnection {

    private static final String mysqlDriver = "com.mysql.jdbc.Driver";
    private static final String databaseUrl = "jdbc:mysql://localhost:3306/textimagelectordb";
    private static final String username = "root";
    private static final String password = "VgZ08PRV4s4";
    
    private Connection connection;
    
    static {
        try {
            Class.forName(mysqlDriver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    public void connect() {
        try {
            connection = DriverManager.getConnection(databaseUrl, username, password);
        } catch(SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    public void disconnect() {
        try {
            connection.close();
        } catch(SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    private Statement getStatement() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch(SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return statement;
    }
    
    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        try {
           resultSet = getStatement().executeQuery(sql);
        } catch(SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return resultSet;
    }

    public Connection getConnection() {
        return connection;
    }
}
