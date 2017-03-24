package com.softwerke.khazipov.store.view.clients;

import com.softwerke.khazipov.store.controller.ClientsController;
import com.softwerke.khazipov.store.model.entities.Client;
import com.softwerke.khazipov.store.view.View;

import java.util.List;
import java.util.Scanner;

/**
 * //TODO: write some javadoc here plz
 */
public class ConsoleClientsSorting implements View {
    private static Scanner scanner;

    static void start(Scanner reader) {
        scanner = reader;
        System.out.println("--------------------------");
        System.out.println("Choose param of sorting:");
        System.out.println("1. Client ID.");
        System.out.println("2. First name.");
        System.out.println("3. Last name.");
        System.out.println("4. Middle name.");
        System.out.println("5. Birthday date.");

        System.out.println("Choose param: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                printClientsSortedByClientID();
                break;
            case 2:
                printClientsSortedByFirstName();
                break;
            case 3:
                printClientsSortedByLastName();
                break;
            case 4:
                printClientsSortedByMiddleName();
                break;
            case 5:
                printClientsSortedByBirthdayDate();
                break;

            default:
                System.out.println("Wrong number! Try again.");
        }
    }

    private static void printClientsSortedByClientID() {
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByClientID();
        System.out.println("Clients, sorted by client ID:");
        for (Client client : sortedClients) {
            System.out.println(client.toString());
        }
    }

    private static void printClientsSortedByFirstName() {
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByFirstName();
        System.out.println("Clients, sorted by first name:");
        for (Client client : sortedClients) {
            System.out.println(client.toString());
        }
    }

    private static void printClientsSortedByLastName() {
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByLastName();
        System.out.println("Clients, sorted by last name:");
        for (Client client : sortedClients) {
            System.out.println(client.toString());
        }
    }

    private static void printClientsSortedByMiddleName() {
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByMiddleName();
        System.out.println("Clients, sorted by middle name:");
        for (Client client : sortedClients) {
            System.out.println(client.toString());
        }
    }

    private static void printClientsSortedByBirthdayDate() {
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByBirthdayDate();
        System.out.println("Clients, sorted by birthday date:");
        for (Client client : sortedClients) {
            System.out.println(client.toString());
        }
    }
}
