package com.softwerke.khazipov.store.view.sales;

import com.softwerke.khazipov.store.controller.SalesController;
import com.softwerke.khazipov.store.model.entities.Sale;
import com.softwerke.khazipov.store.view.View;
import com.softwerke.khazipov.store.view.utils.CollectionPrinter;

import java.util.List;
import java.util.Scanner;

/**
 * //TODO: write some javadoc here plz
 */
public class ConsoleSalesSortingDialog implements View {
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
        List<Sale> sortedSales = SalesController.getListOfSalesSortedBySaleID();
        CollectionPrinter.printList(sortedSales, "Sales, sorted by sale ID:");
    }

    private static void printSalesSortedByClientID() {
        List<Sale> sortedSales = SalesController.getListOfSalesSortedByClientID();
        CollectionPrinter.printList(sortedSales, "Sales, sorted by client ID:");
    }

    private static void printSalesSortedByDate() {
        List<Sale> sortedSales = SalesController.getListOfSalesSortedByDate();
        CollectionPrinter.printList(sortedSales, "Sales, sorted by date:");
    }
}
