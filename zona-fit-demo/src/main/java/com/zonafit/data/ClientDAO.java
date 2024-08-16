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
        ResultSet rs;
        Connection connection_db = ConnectionDB.getConnection();
        String sqlSatatment = "SELECT * FROM zona_fit_db.cliente ORDER BY id_cliente";

        try {
            ps = connection_db.prepareStatement(sqlSatatment);
            rs = ps.executeQuery();
            while (rs.next()) {
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
    public boolean searchClient(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchClient'");
    }

    @Override
    public boolean addClient(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addClient'");
    }

    @Override
    public boolean modifyClient(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifyClient'");
    }

    @Override
    public boolean deleteClient(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteClient'");
    }
    
}
