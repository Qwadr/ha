package com.softwerke.store.controller;

import com.softwerke.store.controller.main.InitialDataGenerator;
import com.softwerke.store.controller.main.Store;
import com.softwerke.store.model.Clients;
import com.softwerke.store.model.entities.Client;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class ClientsControllerTest {

    @BeforeClass
    public static void setUp() {
        InitialDataGenerator.addInitialData();
    }

    @Test
    public void findClientByNegateID() throws Exception {
        Client client;
        client = ClientsController.findClientByID(-1);
        assertNull(client);
    }

    @Test
    public void findClientByCorrectID() throws Exception {
        Client client;
        client = ClientsController.findClientByID(1);
        assertNotNull(client);
    }

    @Test
    public void findExistingClientsByFullName() throws Exception {
        List<Client> clients = ClientsController.findClientByFullName("Ivanov Ivan Ivanovich");
        assertEquals(clients.size(), 2);
    }

    @Test
    public void findExistingClientByFullName() throws Exception {
        List<Client> clients = ClientsController.findClientByFullName("Fadeev Boris Xavierovich");
        assertNotEquals(clients.size(), 0);
    }

    @Test
    public void findNotExistingClientByFullName() throws Exception {
        List<Client> clients = ClientsController.findClientByFullName("1 1 1");
        assertEquals(clients.size(), 0);
    }

    @Test
    public void getListOfClientsSortedByClientID() throws Exception {

    }

    @Test
    public void getListOfClientsSortedByFirstName() throws Exception {
    }

    @Test
    public void getListOfClientsSortedByLastName() throws Exception {
    }

    @Test
    public void getListOfClientsSortedByMiddleName() throws Exception {
    }

    @Test
    public void getListOfClientsSortedByBirthdayDate() throws Exception {
    }


    @Test
    public void beforeClassAnnotationIsWorking() throws Exception {
        Clients clients = Store.clients;
        assertEquals(clients.getListOfClients().size(), 5);
    }
}