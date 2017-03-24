package com.softwerke.khazipov.store.view.sales;

import com.softwerke.khazipov.store.controller.ClientsController;
import com.softwerke.khazipov.store.controller.DevicesController;
import com.softwerke.khazipov.store.controller.SalesController;
import com.softwerke.khazipov.store.controller.main.Store;
import com.softwerke.khazipov.store.view.utils.CollectionPrinter;
import com.softwerke.khazipov.store.view.utils.DateHelper;
import com.softwerke.khazipov.store.model.entities.Client;
import com.softwerke.khazipov.store.model.entities.Device;
import com.softwerke.khazipov.store.model.entities.Sale;
import com.softwerke.khazipov.store.view.View;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
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
            System.out.println("1. Create new sale.");
            System.out.println("2. Show all sales.");
            System.out.println("3. Sort sales.");
            System.out.println("4. Find sale.");
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
                    ConsoleSalesSortingDialog.start(scanner);
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
            client = ClientsController.findClientByID(clientID);
            if (client != null) {
                correctValue = true;
            } else {
                System.out.println("We have no clients with this ID. Try again.");
            }
        }

        Date saleDate = DateHelper.readDate(scanner);

        System.out.println("Enter \"<DeviceID> <Count>\" pairs (enter '0' to finish): ");
        int deviceID = scanner.nextInt();
        int count;
        Map<Device, Integer> devices = new HashMap<>();
        while (deviceID != 0) {
            count = scanner.nextInt();
            Device currentDevice = DevicesController.findDeviceByID(deviceID);
            int currentCount = devices.getOrDefault(deviceID, 0);
            devices.put(currentDevice, currentCount + count);

            deviceID = scanner.nextInt();
        }


        Store.sales.addSale(client, saleDate, devices);
        System.out.println("Success! Sale added.");
    }

    private static void findSaleAndPrintInfoAboutIt() {
        System.out.println("Choose operation: ");
        System.out.println("1. Find sale by sale ID.");
        System.out.println("2. Find sale by client ID.");
        System.out.println("3. Find sale by date.");
        System.out.println("0. Step back.");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter sale ID: ");
                int saleID = scanner.nextInt();
                Sale sale = SalesController.findSaleBySaleID(saleID);
                if (sale != null) {
                    System.out.println("Sale found. Info about it: ");
                    System.out.println(sale.toString());
                } else {
                    System.out.println("No such sale.");
                }
                break;

            case 2:
                System.out.println("Enter client ID: ");
                int clientID = scanner.nextInt();
                List<Sale> salesToThisClient = SalesController.findSaleByClientID(clientID);
                if (salesToThisClient != null) {
                    System.out.println("We have something for you! Here all sales of this client: ");
                    CollectionPrinter.printList(salesToThisClient);
                } else {
                    System.out.println("No such sale.");
                }
                break;

            case 3:
                Date date = DateHelper.readDate(scanner);
                List<Sale> salesInThisDay = SalesController.findSaleByDate(date); //Sale sale
                if (salesInThisDay.size() != 0) {
                    System.out.println("We have something for you! Here all sales of this day:");
                    CollectionPrinter.printList(salesInThisDay);
                } else {
                    System.out.println("We have no sales with this brand."); //TODO lec mi spik from mai hart in inglish
                }
                break;

            case 0:
                break;

            default:
                System.out.println("Bad number.");
        }
    }
}
