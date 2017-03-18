package model.impl;

import model.entities.Client;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Implementation of "Clients" DAO interface. More information will be added later.
 */
public class ClientsImpl {
    private ArrayList<Client> clients;

    public void addClient(String firstName, String lastName, String middleName, Date birthDate) {
        clients.add(new Client(firstName, lastName, middleName, birthDate));
    }

    public ClientsImpl() {
        clients = new ArrayList<>();
    }

    public ArrayList<Client> getClients() {
        return clients;
    }
}
