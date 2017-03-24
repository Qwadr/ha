package com.softwerke.khazipov.store.controller;

import com.softwerke.khazipov.store.controller.main.Store;
import com.softwerke.khazipov.store.model.entities.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Clients com.softwerke.khazipov.store.controller without realisation.
 */
public class ClientsController {
    public static List<Client> getSortedListOfClients(int ClientID) {

        return null;
    }

    public static Client findClientByID(int ClientID) {
        Client wantedClient = null;
        List<Client> allClients = Store.clients.getListOfClients();
        for (Client client : allClients) {
            if (client.getClientID() == ClientID) {
                wantedClient = client;
                break;
            }
        }
        return wantedClient;
    }

    public static List<Client> findClientByFullName(String clientFullName) {
        List<Client> wantedClients = new ArrayList<>();

        List<Client> allClients = Store.clients.getListOfClients();
        for (Client client : allClients) {
            if (client.getFullName().equals(clientFullName)) {
                wantedClients.add(client);
            }
        }

        return wantedClients;
    }
}