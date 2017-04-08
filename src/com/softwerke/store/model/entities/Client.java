package com.softwerke.store.model.entities;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * "Client" entity.
 * Realizes Builder pattern.
 */
public class Client {
    private int clientID;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;

    private static int numberOfClients = 0;

    public Client() {
        this.clientID = ++numberOfClients;
    }

    public Client(ClientBuilder builder) {
        this();
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.birthDate = builder.birthDate;
    }

    public int getClientID() {
        return clientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Client ");
        sb.append("ID = ").append(clientID);
        sb.append("; full name: \"")
                .append(lastName).append(" ")
                .append(firstName).append(" ")
                .append(middleName).append("\"")
                .append("; birthday date: ")
                .append((new SimpleDateFormat("dd.MM.yyyy")).format(birthDate))
                .append(".");
        return sb.toString();
    }

    public static class ClientBuilder {
        private String firstName;
        private String lastName;
        private String middleName;
        private Date birthDate;

        public ClientBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ClientBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ClientBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public ClientBuilder setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }
}
