package com.softwerke.store.view.devices;

import com.softwerke.store.controller.DevicesController;
import com.softwerke.store.model.entities.Device;
import com.softwerke.store.view.ConsoleView;
import com.softwerke.store.view.utils.CollectionPrinter;

import java.util.List;
import java.util.Scanner;

/**
 * A part of the console interaction with user about
 * the selection of the device sorting parameters.
 */
class ConsoleDeviceSortingDialog implements ConsoleView {
    private static Scanner scanner;

    static void start(Scanner reader) {
        scanner = reader;
        System.out.println("--------------------------");
        System.out.println("Choose param of sorting:");
        System.out.println("1. Device ID.");
        System.out.println("2. Device type.");
        System.out.println("3. Brand.");
        System.out.println("4. Model.");
        System.out.println("5. Release date.");
        System.out.println("6. Price.");

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
                printDevicesSortedByReleaseDate();
                break;
            case 6:
                printDevicesSortedByPrice();
                break;
        }
    }

    private static void printDevicesSortedByDeviceID() {
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByDeviceID();
        CollectionPrinter.printList("Devices, sorted by price:", sortedDevices);
    }

    private static void printDevicesSortedByDeviceType() {
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByDeviceType();
        CollectionPrinter.printList("Devices, sorted by price:", sortedDevices);
    }

    private static void printDevicesSortedByBrand() {
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByBrand();
        CollectionPrinter.printList("Devices, sorted by price:", sortedDevices);
    }

    private static void printDevicesSortedByModel() {
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByModel();
        CollectionPrinter.printList("Devices, sorted by price:", sortedDevices);
    }

    private static void printDevicesSortedByReleaseDate() {
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByReleaseDate();
        CollectionPrinter.printList("Devices, sorted by price:", sortedDevices);
    }

    private static void printDevicesSortedByPrice() {
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByPrice();
        CollectionPrinter.printList("Devices, sorted by price:", sortedDevices);
    }
}
