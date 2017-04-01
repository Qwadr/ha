package com.softwerke.store.view.clients;

import com.softwerke.store.controller.ClientsController;
import com.softwerke.store.model.entities.Client;
import com.softwerke.store.view.View;
import com.softwerke.store.view.utils.CollectionPrinter;

import java.util.List;
import java.util.Scanner;

/**
 * A part of the console interaction with user about
 * the selection of the client sorting parameters.
 */
class ConsoleClientsSortingDialog implements View {
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
        CollectionPrinter.printList("Clients, sorted by client ID:", sortedClients);
    }

    private static void printClientsSortedByFirstName() {
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByFirstName();
        CollectionPrinter.printList("Clients, sorted by first name:", sortedClients);
    }

    private static void printClientsSortedByLastName() {
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByLastName();
        CollectionPrinter.printList("Clients, sorted by last name:", sortedClients);
    }

    private static void printClientsSortedByMiddleName() {
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByMiddleName();
        CollectionPrinter.printList("Clients, sorted by middle name:", sortedClients);
    }

    private static void printClientsSortedByBirthdayDate() {
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByBirthdayDate();
        CollectionPrinter.printList("Clients, sorted by birthday date:", sortedClients);
    }
}
