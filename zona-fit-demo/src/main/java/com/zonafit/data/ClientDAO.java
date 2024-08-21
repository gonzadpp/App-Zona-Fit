package com.zonafit.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zonafit.connection.ConnectionDB;
import com.zonafit.domain.Client;

public class ClientDAO implements IClientDAO{ 

    @Override
    public List<Client> getClientsList() {
        List<Client> clients = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs; //Nos permite recibir la información de la consulta que hemos realizado.
        Connection connection_db = ConnectionDB.getConnection();
        String sqlSatatment = "SELECT * FROM zona_fit_db.cliente ORDER BY id_cliente";

        try {
            ps = connection_db.prepareStatement(sqlSatatment);
            rs = ps.executeQuery();
            while (rs.next()) { //.next() para preguntar si tenemos registros a iterar (Si no hay nada que iterar retorna falso)
                Client client = new Client();
                client.setId_cliente(rs.getInt("id_cliente"));
                client.setName(rs.getString("nombre"));
                client.setLastName(rs.getString("apellido"));
                client.setMembership(rs.getInt("membresia"));
                clients.add(client);
            }
        } catch (Exception e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        finally{
            try {
                connection_db.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión a la base de datos " + e.getMessage());
            }
        }
        return clients;
    }

    @Override
    public boolean searchClientByID(Client client) {
        PreparedStatement ps;
        ResultSet rs;
        Connection connection_db = ConnectionDB.getConnection();
        //Signo de interrogación significa que nuestro sql statement requiere un parametro
        String sqlStatement = "SELECT * FROM zona_fit_db.cliente WHERE id_cliente = ?"; 
        try {
            ps = connection_db.prepareStatement(sqlStatement);
            // Despues de obtener nuestro prepareSatatement, llamamos al metodo ps.setInt para pasarle el parametro 
            // El parametro es de tipo Int. le pasamos el indice y el parametro (Indice del cliente que se está solicitando).
            ps.setInt(1, client.getId_cliente()); 
            rs = ps.executeQuery();
            if (rs.next()) {
                client.setName(rs.getString("nombre"));
                client.setLastName(rs.getString("apellido"));
                client.setMembership(rs.getInt("membresia"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar cliente por ID " + e.getMessage());
        }
        finally{
            try {
                connection_db.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión a la base de datos " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean addClient(Client client) {
        PreparedStatement ps;
        Connection connection_db = ConnectionDB.getConnection();
        String sqlStatement = "INSERT INTO `zona_fit_db`.`cliente` (`nombre`, `apellido`, `membresia`) VALUES (?, ?, ?)";
        try {
            ps = connection_db.prepareStatement(sqlStatement);
            ps.setString(1, client.getName());
            ps.setString(2, client.getLastName());
            ps.setInt(3, client.getMembership());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar cliente " + e.getMessage());
        }
        finally{
            try {
                connection_db.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modifyClient(Client client) {
        return false;
    }

    @Override
    public boolean deleteClient(Client client) {
        return false;
    }
    
}
