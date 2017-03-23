package com.softwerke.khazipov.store.view.clients;

import com.softwerke.khazipov.store.controller.ClientsController;
import com.softwerke.khazipov.store.controller.main.Store;
import com.softwerke.khazipov.store.model.entities.Client;
import com.softwerke.khazipov.store.view.View;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * All vzaimodeistvie about clients. TODO vzaimodeistvie translation
 */
public class ConsoleClients implements View {
    private static Scanner scanner;
    private static boolean running = false;


    public static void start(Scanner reader) {
        scanner = reader;
        running = true;
        while (running) {
            System.out.println("--------------------------");
            System.out.println("List of opportunities:");
            System.out.println("1. Create new client.");
            System.out.println("2. Show all clients.");
            System.out.println("3. Sort clients.");
            System.out.println("4. Find client.");
            System.out.println("0. Back to main menu.");

            System.out.println("Choose operation: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    readDataAndCreateNewClient();
                    break;
                case 2:
                    printAllClientsInfo();
                    break;
                case 3:
                    ConsoleClientsSorting.start(scanner);
                    break;
                case 4:
                    findClientAndPrintInfoAboutIt();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Wrong number! Try again.");
            }
        }

    }

    public static void printAllClientsInfo() {
        System.out.println("We have " + Store.clients.getListOfClients().size() + " clients: ");
        for (Client client : Store.clients.getListOfClients()) {
            System.out.println(client.toString());
        }
    }

    private static void readDataAndCreateNewClient() {
        System.out.println("First name: ");
        String firstName = scanner.next();

        System.out.println("Second name: ");
        String secondName = scanner.next();

        System.out.println("Third name: ");
        String thirdName = scanner.next();

        Date birthDate = null;

        boolean correctValue = false;
        while (!correctValue) {
            try {
                System.out.println("Birthday date (in \"dd-mm-yyyy\" format): ");
                birthDate = new Date(
                        (new SimpleDateFormat("dd-MM-yyyy")).parse(scanner.next()).getTime());
                correctValue = true;
            } catch (ParseException e) {
                System.out.println("Wrong date. Try again.");
            }
        }

        Store.clients.addClient(firstName, secondName, thirdName, birthDate);
        System.out.println("Success! Client added.");
    }

    private static void findClientAndPrintInfoAboutIt() {
        Client client;
        System.out.println("Choose operation: ");
        System.out.println("1. Find by ID.");
        System.out.println("2. Find by full name.");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter ID: ");
                int clientID = scanner.nextInt();
                client = ClientsController.findClientByID(clientID);
                if (client != null) {
                    System.out.println("Client found. Info about him: ");
                    System.out.println(client.toString());
                } else {
                    System.out.println("No such client.");
                }
                break;
            case 2:
                System.out.println("Enter full name: ");
                String fullName = scanner.nextLine();
                client = ClientsController.findClientByFullName(fullName);
                if (client != null) {
                    System.out.println("Client found. Info about him: ");
                    System.out.println(client.toString());
                } else {
                    System.out.println("No such client.");
                }
                break;
            default:
                System.out.println("Bad number.");
        }
    }

}
