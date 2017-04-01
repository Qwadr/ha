package com.softwerke.store.model.impl;

import com.softwerke.store.model.Clients;
import com.softwerke.store.model.entities.Client;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of "Clients" DAO interface. More information will be added later.
 */
public class ClientsImpl implements Clients {
    private static ClientsImpl instance;
    private static ArrayList<Client> clients;

    private ClientsImpl() {
        clients = new ArrayList<>();
    }

    public static ClientsImpl getInstance() {
        if (instance == null) {
            instance = new ClientsImpl();
        }
        return instance;
    }

    @Override
    public void addClient(String firstName, String lastName, String middleName, Date birthDate) {
        clients.add(new Client(firstName, lastName, middleName, birthDate));
    }

    public List<Client> getListOfClients() {
        return clients;
    }
}
