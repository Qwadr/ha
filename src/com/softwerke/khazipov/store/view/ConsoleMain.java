package com.softwerke.khazipov.store.view;

import com.softwerke.khazipov.store.controller.main.Store;
import com.softwerke.khazipov.store.model.entities.Client;
import com.softwerke.khazipov.store.model.entities.Device;
import com.softwerke.khazipov.store.model.entities.Sale;

import java.util.Scanner;

/**
 * Created by Qwadr on 22.03.2017 at 20:54.
 */
public class ConsoleMain implements View {
    private boolean running;
    private static Scanner scanner;

    @Override
    public void start() {
        scanner = new Scanner(System.in);
        running = true;
        System.out.println("Hello! Glad to see you in our imaginary store!");
        while (running) {
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
            System.out.println("--------------------------");
        }
    }

    private void printAllInfo() {
        System.out.println("All info:");

        System.out.println("We have " + Store.clients.getListOfClients().size() + " clients: ");
        for (Client client : Store.clients.getListOfClients()) {
            System.out.println(client.toString());
        }

        System.out.println("We have " + Store.devices.getListOfDevices().size() + " devices: ");
        for (Device device : Store.devices.getListOfDevices()) {
            System.out.println(device.toString());
        }

        System.out.println("We have " + Store.sales.getListOfSales().size() + " sales: ");
        for (Sale sale : Store.sales.getListOfSales()) {
            System.out.println(sale.toString());
        }

    }
}
