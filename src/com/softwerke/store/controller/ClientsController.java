package com.softwerke.store.controller;

import com.softwerke.store.controller.main.Store;
import com.softwerke.store.model.entities.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clients controller with realisation of search
 * and sorting methods.
 */
public class ClientsController {

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

    public static List<Client> findClientsByFullName(String clientFullName) {
        List<Client> wantedClients = new ArrayList<>();

        List<Client> allClients = Store.clients.getListOfClients();
        for (Client client : allClients) {
            if (client.getFullName().equals(clientFullName)) {
                wantedClients.add(client);
            }
        }

        return wantedClients;
    }

    public static List<Client> findClientsByPartOfFullName(String partOfFullName) {
        List<Client> wantedClients = new ArrayList<>();

        List<Client> allClients = Store.clients.getListOfClients();
        for (Client client : allClients) {
            if (client.getFullName().toLowerCase().contains(partOfFullName.toLowerCase())) {
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
                return Integer.compare(o1.getClientID(), o2.getClientID());
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

    public static List<Client> getListOfClientsSortedByFullName() {
        List<Client> allClients = Store.clients.getListOfClients();
        Collections.sort(allClients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getFullName().compareTo(o2.getFullName());
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