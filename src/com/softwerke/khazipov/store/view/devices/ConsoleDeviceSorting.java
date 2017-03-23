package com.softwerke.khazipov.store.view.devices;

import com.softwerke.khazipov.store.view.View;

import java.util.Scanner;

/**
 * //TODO: write some javadoc here plz
 */
public class ConsoleDeviceSorting implements View {
    private static Scanner scanner;

    static void start(Scanner reader) {
        scanner = reader;
        System.out.println("--------------------------");
        System.out.println("Choose param of sorting:");
        System.out.println("1. Device ID.");
        System.out.println("2. Device type.");
        System.out.println("3. Brand.");
        System.out.println("4. Model.");
        System.out.println("5. Color.");
        System.out.println("6. Release date.");
        System.out.println("7. Price.");

        System.out.println("Choose param: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                printDevicesSortedByDeviceID();
                break;
            case 2:
                printDevicesSortedByDeviceType();
                break;
            case 3:
                printDevicesSortedByBrand();
                break;
            case 4:
                printDevicesSortedByModel();
                break;
            case 5:
                printDevicesSortedByColor();
                break;
            case 6:
                printDevicesSortedByReleaseDate();
                break;
            case 7:
                printDevicesSortedByPrice();
                break;

        }
    }

    private static void printDevicesSortedByDeviceID() {
        //TODO: write some code here
    }

    private static void printDevicesSortedByDeviceType() {
        //TODO: write some code here
    }

    private static void printDevicesSortedByBrand() {
        //TODO: write some code here
    }

    private static void printDevicesSortedByModel() {
        //TODO: write some code here
    }

    private static void printDevicesSortedByColor() {
        //TODO: write some code here
    }

    private static void printDevicesSortedByReleaseDate() {
        //TODO: write some code here
    }

    private static void printDevicesSortedByPrice() {
        //TODO: write some code here
    }
}
