package com.softwerke.store.view;

import com.softwerke.store.view.clients.ConsoleClients;
import com.softwerke.store.view.devices.ConsoleDevices;
import com.softwerke.store.view.sales.ConsoleSales;

import java.util.Scanner;

/**
 * Main menu of console interaction.
 */
public class ConsoleMain implements ConsoleView {
    private boolean running;
    private static Scanner scanner;

    public void start() {
        scanner = new Scanner(System.in);
        running = true;
        System.out.println("Hello! Glad to see you in our imaginary store!");
        while (running) {
            System.out.println("--------------------------");
            System.out.println("List of opportunities:");
            System.out.println("1. Working with clients.");
            System.out.println("2. Working with devices.");
            System.out.println("3. Working with sales.");
            System.out.println("4. Print all info.");
            System.out.println("0. Quit.");

            System.out.println("Choose operation: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ConsoleClients.start(scanner);
                    break;
                case 2:
                    ConsoleDevices.start(scanner);
                    break;
                case 3:
                    ConsoleSales.start(scanner);
                    break;
                case 4:
                    printAllInfo();
                    break;
                case 0:
                    System.out.println("Bye-bye!");
                    running = false;
                    break;
                default:
                    System.out.println("Wrong number! Try again.");
            }

        }
    }

    private void printAllInfo() {
        System.out.println("All info:");

        ConsoleClients.printAllClientsInfo();

        ConsoleDevices.printAllDevicesInfo();

        ConsoleSales.printAllSalesInfo();
    }
}
