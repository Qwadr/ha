package com.softwerke.store.model;

import com.softwerke.store.model.entities.Client;

import java.util.Date;
import java.util.List;

/**
 * DAO interface for "Client" entity
 */
public interface Clients {

    /**
     * Create new client.
     *
     * @param firstName   - first name of client, any String
     * @param lastName    - last name of client, any String
     * @param middleName  - middle name of client, any String
     * @param birthDate   - birthday date, java.util.Date
     */
    void addClient(String firstName, String lastName, String middleName, Date birthDate);

    /**
     * Getting a list of all clients in the system.
     */
    List<Client> getListOfClients();

}
