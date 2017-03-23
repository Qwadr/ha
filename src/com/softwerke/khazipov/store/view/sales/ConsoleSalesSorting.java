package com.softwerke.khazipov.store.view.sales;

import com.softwerke.khazipov.store.controller.SalesController;
import com.softwerke.khazipov.store.view.View;

import java.util.Scanner;

/**
 * //TODO: write some javadoc here plz
 */
public class ConsoleSalesSorting implements View {
    private static Scanner scanner;

    static void start(Scanner reader) {
        scanner = reader;
        System.out.println("--------------------------");
        System.out.println("Choose param of sorting:");
        System.out.println("1. Sale ID.");
        System.out.println("2. Client ID.");
        System.out.println("3. Sale date.");

        System.out.println("Choose param: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                printSalesSortedBySaleID();
                break;
            case 2:
                printSalesSortedByClientID();
                break;
            case 3:
                printSalesSortedByDate();
                break;
            default:
                System.out.println("Wrong number! Try again.");
        }
    }

    private static void printSalesSortedBySaleID() {
        //TODO: write some code here
    }

    private static void printSalesSortedByClientID() {
        //TODO: write some code here
    }

    private static void printSalesSortedByDate() {
        //TODO: write some code here
    }
}
