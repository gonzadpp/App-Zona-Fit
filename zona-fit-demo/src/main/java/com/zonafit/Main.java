package com.zonafit;

import java.sql.Connection;

import com.zonafit.connection.ConnectionDB;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a Zona Fit!");
        System.out.println("Cargando base de datos...");
         Connection db_Connection = ConnectionDB.getConnection();
         if (db_Connection != null) {
            System.out.println("Conexión exitosa " + db_Connection);
         } else {
            System.out.println("Error de conexión");
         }
    }
}