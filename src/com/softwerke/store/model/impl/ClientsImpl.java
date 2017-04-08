package com.softwerke.store.model.impl;

import com.softwerke.store.model.Clients;
import com.softwerke.store.model.entities.Client;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of "Clients" DAO interface.
 * <p>
 * Class realizes Singleton pattern.
 * <p>
 * "addClient" method creates a new client using ClientBuilder.
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
        Client newClient = (new Client.ClientBuilder())
                .setFirstName(firstName)
                .setLastName(lastName)
                .setMiddleName(middleName)
                .setBirthDate(birthDate)
                .build();
        clients.add(newClient);
    }

    @Override
    public List<Client> getListOfClients() {
        return clients;
    }
}
