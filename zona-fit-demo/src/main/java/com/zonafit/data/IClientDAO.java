package com.zonafit.data;

import java.util.List;

import com.zonafit.domain.Client;

public interface IClientDAO {
    List<Client> getClientsList();
    boolean searchClientByID(Client client);
    boolean addClient(Client client);
    boolean modifyClient(Client client);
    boolean deleteClient(Client client);
}
