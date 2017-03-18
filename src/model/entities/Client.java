package model.entities;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * "Client" entity. More information will be added later.
 */
public class Client {
    private int clientID;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;

    private static int numberOfClients;

    public Client(String firstName, String lastName, String middleName, Date birthDate) {
        this.clientID = ++numberOfClients;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
    }

    public int getClientID() {
        return clientID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Client ");
        sb.append("ID = ").append(clientID);
        sb.append("; full name: \"")
                .append(firstName).append(" ")
                .append(lastName).append(" ")
                .append(middleName).append("\"")
                .append("; birthday date: ")
                .append((new SimpleDateFormat("dd.MM.yyyy")).format(birthDate))
                .append(".");
        return sb.toString();
    }
}
