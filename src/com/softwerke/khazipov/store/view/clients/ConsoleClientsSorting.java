package com.softwerke.khazipov.store.view.clients;

import com.softwerke.khazipov.store.view.View;

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
        //TODO: write some code here
    }

    private static void printClientsSortedByFirstName() {
        //TODO: write some code here
    }

    private static void printClientsSortedByLastName() {
        //TODO: write some code here
    }

    private static void printClientsSortedByMiddleName() {
        //TODO: write some code here
    }

    private static void printClientsSortedByBirthdayDate() {
        //TODO: write some code here
    }
}