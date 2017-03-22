package com.softwerke.khazipov.store.model;

import com.softwerke.khazipov.store.model.entities.Client;

import java.sql.Date;
import java.util.List;

/**
 * DAO interface for "Client" entity
 */
public interface Clients {

    void addClient(String firstName, String lastName, String middleName, Date birthDate);

    Client findClient(int ID);

    List<Client> getListOfClients();

}
