package com.softwerke.khazipov.store.view.sales;

import com.softwerke.khazipov.store.controller.main.Store;
import com.softwerke.khazipov.store.model.entities.Client;
import com.softwerke.khazipov.store.model.entities.Device;
import com.softwerke.khazipov.store.model.entities.Sale;
import com.softwerke.khazipov.store.view.View;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * All vzaimodeistvie about sales. TODO vzaimodeistvie translation
 */
public class ConsoleSales implements View {
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
                    readDataAndCreateNewSale();
                    break;
                case 2:
                    printAllSalesInfo();
                    break;
                case 3:
                    ConsoleSalesSorting.start(scanner);
                    break;
                case 4:
                    findSaleAndPrintInfoAboutIt();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Wrong number! Try again.");
            }
        }

    }

    public static void printAllSalesInfo() {
        System.out.println("We have " + Store.sales.getListOfSales().size() + " sales: ");
        for (Sale sale : Store.sales.getListOfSales()) {
            System.out.println(sale.toString());
        }
    }

    private static void readDataAndCreateNewSale() {
        boolean correctValue = false;
        Client client = null;
        while (!correctValue) {
            System.out.println("Client ID: ");
            int clientID = scanner.nextInt();
            client = Store.findClient(clientID);
            if (client != null) {
                correctValue = true;
            } else {
                System.out.println("We have no clients with this ID. Try again.");
            }
        }

        Date saleDate = null;
        correctValue = false;
        while (!correctValue) {
            try {
                System.out.println("Release date (in \"dd-mm-yyyy\" format): ");
                saleDate = new Date(
                        (new SimpleDateFormat("dd-MM-yyyy")).parse(scanner.next()).getTime());
                correctValue = true;
            } catch (ParseException e) {
                System.out.println("Wrong date. Try again.");
            }
        }

        System.out.println("Enter \"<DeviceID> <Count>\" pairs (enter '0' to finish): ");
        int deviceID = scanner.nextInt();
        int count;
        Map<Device, Integer> devices = new HashMap<>();
        while (deviceID != 0) {
            count = scanner.nextInt();
            Device currentDevice = Store.findDevice(deviceID);
            int currentCount = devices.getOrDefault(deviceID, 0);
            devices.put(currentDevice, currentCount + count);

            deviceID = scanner.nextInt();
        }


        Store.sales.addSale(client, saleDate, devices);
        System.out.println("Success! Sale added.");
    }

    private static void findSaleAndPrintInfoAboutIt() {
        //TODO: write some code here
    }
}
