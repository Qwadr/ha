package com.softwerke.store.controller;

import com.softwerke.store.controller.main.InitialDataGenerator;
import com.softwerke.store.controller.main.Store;
import com.softwerke.store.model.dao.Clients;
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
    public void findNotExistingClientByFullName() throws Exception {
        List<Client> clients = ClientsController.findClientsByFullName("1 1 1");
        assertEquals(clients.size(), 0);
    }

    @Test
    public void findExistingClientsByFullName() throws Exception {
        List<Client> clients = ClientsController.findClientsByFullName("Ivanov Ivan Ivanovich");
        boolean resultIsCorrect = clients.size() > 0;
        assertTrue(resultIsCorrect);
    }

    @Test
    public void getListOfClientsSortedByClientID() throws Exception {
        boolean resultIsCorrect = true;
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByClientID();
        for (int i = 0; i < sortedClients.size() - 1; i++) {
            if (sortedClients.get(i).getClientID() > sortedClients.get(i + 1).getClientID()) {
                resultIsCorrect = false;
            }
        }
        assertTrue(resultIsCorrect);
    }

    @Test
    public void getListOfClientsSortedByFirstName() throws Exception {
        boolean resultIsCorrect = true;
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByFirstName();
        for (int i = 0; i < sortedClients.size() - 1; i++) {
            if (sortedClients.get(i).getFirstName()
                    .compareTo(sortedClients.get(i + 1).getFirstName()) > 0) {
                resultIsCorrect = false;
            }
        }
        assertTrue(resultIsCorrect);
    }

    @Test
    public void getListOfClientsSortedByLastName() throws Exception {
        boolean resultIsCorrect = true;
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByLastName();
        for (int i = 0; i < sortedClients.size() - 1; i++) {
            if (sortedClients.get(i).getLastName()
                    .compareTo(sortedClients.get(i + 1).getLastName()) > 0) {
                resultIsCorrect = false;
            }
        }
        assertTrue(resultIsCorrect);
    }

    @Test
    public void getListOfClientsSortedByMiddleName() throws Exception {
        boolean resultIsCorrect = true;
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByMiddleName();
        for (int i = 0; i < sortedClients.size() - 1; i++) {
            if (sortedClients.get(i).getMiddleName()
                    .compareTo(sortedClients.get(i + 1).getMiddleName()) > 0) {
                resultIsCorrect = false;
            }
        }
        assertTrue(resultIsCorrect);
    }

    @Test
    public void getListOfClientsSortedByBirthdayDate() throws Exception {
        boolean resultIsCorrect = true;
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByBirthdayDate();
        for (int i = 0; i < sortedClients.size() - 1; i++) {
            if (sortedClients.get(i).getBirthDate()
                    .compareTo(sortedClients.get(i + 1).getBirthDate()) > 0) {
                resultIsCorrect = false;
            }
        }
        assertTrue(resultIsCorrect);
    }


    @Test
    public void beforeClassAnnotationIsWorking() throws Exception {
        Clients clients = Store.clients;
        assertEquals(clients.getListOfClients().size(), 5);
    }
}