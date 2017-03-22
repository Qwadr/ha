package model.impl;

import model.Clients;
import model.entities.Client;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of "Clients" DAO interface. More information will be added later.
 */
public class ClientsImpl implements Clients {
    private static ArrayList<Client> clients;

    public ClientsImpl() {
        clients = new ArrayList<>();
    }

    @Override
    public void addClient(String firstName, String lastName, String middleName, Date birthDate) {
        clients.add(new Client(firstName, lastName, middleName, birthDate));
    }

    @Override
    public Client findClient(int ID) {
        Client existingClient = null;
        for (Client client : clients) {
            if (client.getClientID() == ID) {
                existingClient = client;
            }
        }
        return existingClient;
    }

    public List<Client> getListOfClients() {
        return clients;
    }
}
