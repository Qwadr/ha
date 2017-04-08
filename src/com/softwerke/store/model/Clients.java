package com.softwerke.store.model;

import com.softwerke.store.model.entities.Client;

import java.util.Date;
import java.util.List;

/**
 * DAO interface for "Client" entity
 */
public interface Clients {

    void addClient(String firstName, String lastName, String middleName, Date birthDate);

    List<Client> getListOfClients();

}
