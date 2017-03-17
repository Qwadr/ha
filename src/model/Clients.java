package model;

import entities.Client;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Qwadr on 09.03.2017 at 21:23.
 */
public class Clients {
    ArrayList<Client> clients;

    public void addClient(String firstName, String lastName, String middleName, Date birthDate) {
        clients.add(new Client(firstName, lastName, middleName, birthDate));
    }

    public Clients() {
        clients = new ArrayList<>();
    }

    public ArrayList<Client> getClients() {
        return clients;
    }
}
