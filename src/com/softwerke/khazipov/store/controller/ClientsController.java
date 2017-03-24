package com.softwerke.khazipov.store.controller;

import com.softwerke.khazipov.store.controller.main.Store;
import com.softwerke.khazipov.store.model.entities.Client;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clients controller with realisation of search methods.
 */
public class ClientsController {
    public static List<Client> getSortedListOfClients(int ClientID) {
        //TODO sorting
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


    public static List<Client> getListOfClientsSortedByClientID() {
        List<Client> allClients = Store.clients.getListOfClients();
        Collections.sort(allClients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return Integer.compare(o1.getClientID(),o2.getClientID());
            }
        });
        return allClients;
    }

    public static List<Client> getListOfClientsSortedByFirstName() {
        List<Client> allClients = Store.clients.getListOfClients();
        Collections.sort(allClients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
        return allClients;

    }

    public static List<Client> getListOfClientsSortedByLastName() {
        List<Client> allClients = Store.clients.getListOfClients();
        Collections.sort(allClients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        return allClients;
    }

    public static List<Client> getListOfClientsSortedByMiddleName() {
        List<Client> allClients = Store.clients.getListOfClients();
        Collections.sort(allClients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getMiddleName().compareTo(o2.getMiddleName());
            }
        });
        return allClients;
    }

    public static List<Client> getListOfClientsSortedByBirthdayDate() {
        List<Client> allClients = Store.clients.getListOfClients();
        Collections.sort(allClients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getBirthDate().compareTo(o2.getBirthDate());
            }
        });
        return allClients;
    }
}