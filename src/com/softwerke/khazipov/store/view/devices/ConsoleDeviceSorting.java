package com.softwerke.khazipov.store.view.devices;

import com.softwerke.khazipov.store.controller.DevicesController;
import com.softwerke.khazipov.store.model.entities.Device;
import com.softwerke.khazipov.store.view.View;

import java.util.List;
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
        System.out.println("Devices, sorted by device ID:");
        for (Device device : sortedDevices) {
            System.out.println(device.toString());
        }
    }

    private static void printDevicesSortedByDeviceType() {
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByDeviceType();
        System.out.println("Devices, sorted by device ID:");
        for (Device device : sortedDevices) {
            System.out.println(device.toString());
        }
    }

    private static void printDevicesSortedByBrand() {
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByBrand();
        System.out.println("Devices, sorted by device ID:");
        for (Device device : sortedDevices) {
            System.out.println(device.toString());
        }
    }

    private static void printDevicesSortedByModel() {
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByModel();
        System.out.println("Devices, sorted by device ID:");
        for (Device device : sortedDevices) {
            System.out.println(device.toString());
        }
    }

    private static void printDevicesSortedByReleaseDate() {
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByReleaseDate();
        System.out.println("Devices, sorted by device ID:");
        for (Device device : sortedDevices) {
            System.out.println(device.toString());
        }
    }

    private static void printDevicesSortedByPrice() {
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByPrice();
        System.out.println("Devices, sorted by device ID:");
        for (Device device : sortedDevices) {
            System.out.println(device.toString());
        }
    }
}
