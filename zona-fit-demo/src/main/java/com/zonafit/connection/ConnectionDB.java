package com.zonafit.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    public static Connection getConnection(){
        Connection connection = null;
        var dataBase = "zona_fit_db";
        var url = "jdbc:mysql://localhost:3306/" + dataBase;
        var user = "root";
        var password = "admin";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("No se puede conectar a la DB " + e.getMessage());
        }
        return connection;
    }
}
