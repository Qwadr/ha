package com.softwerke.khazipov.store.view.devices;

import com.softwerke.khazipov.store.controller.main.Store;
import com.softwerke.khazipov.store.model.entities.Device;
import com.softwerke.khazipov.store.model.entities.enums.DeviceType;
import com.softwerke.khazipov.store.view.View;

import java.awt.Color;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * All vzaimodeistvie about devices. TODO vzaimodeistvie translation
 */
public class ConsoleDevices implements View {
    private static Scanner scanner;
    private static boolean running = false;

    public static void start(Scanner reader) {
        scanner = reader;
        running = true;
        while (running) {
            System.out.println("--------------------------");
            System.out.println("List of opportunities:");
            System.out.println("1. Create new device.");
            System.out.println("2. Show all devices.");
            System.out.println("3. Sort devices.");
            System.out.println("4. Find device.");
            System.out.println("0. Back to main menu.");

            System.out.println("Choose operation: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    readDataAndCreateNewDevice();
                    break;
                case 2:
                    printAllDevicesInfo();
                    break;
                case 3:
                    ConsoleDeviceSorting.start(scanner);
                    break;
                case 4:
                    findDeviceAndPrintInfoAboutIt();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Wrong number! Try again.");
            }
        }

    }

    public static void printAllDevicesInfo() {
        System.out.println("We have " + Store.devices.getListOfDevices().size() + " devices: ");
        for (Device device : Store.devices.getListOfDevices()) {
            System.out.println(device.toString());
        }
    }

    private static void readDataAndCreateNewDevice() {
        System.out.println("Choose device type: ");
        System.out.println("1. Telephone");
        System.out.println("2. Tablet");
        System.out.println("3. Laptop");
        System.out.println("4. Walkman");
        int choice = scanner.nextInt();
        DeviceType deviceType = DeviceType.NOT_INITIALIZED;
        switch (choice) {
            case 1:
                deviceType = DeviceType.TELEPHONE;
                break;
            case 2:
                deviceType = DeviceType.TABLET;
                break;
            case 3:
                deviceType = DeviceType.LAPTOP;
                break;
            case 4:
                deviceType = DeviceType.WALKMAN;
        }

        System.out.println("Brand: ");
        String brand = scanner.next();

        System.out.println("Model: ");
        String model = scanner.next();

        boolean correctValue = false;
        Color color = Color.black;
        while (!correctValue) {
            System.out.println("Color: ");
            try {
                Field field = Class.forName("java.awt.Color").getField(scanner.next());
                color = (Color) field.get(null);
                correctValue = true;
            } catch (Exception e) {
                System.out.println("Wrong color name! Try again.");
            }
        }

        System.out.println("Price (in rubles): ");
        BigDecimal price = new BigDecimal(scanner.next());

        Date releaseDate = null;
        correctValue = false;
        while (!correctValue) {
            try {
                System.out.println("Release date (in \"dd-mm-yyyy\" format): ");
                releaseDate = new Date(
                        (new SimpleDateFormat("dd-MM-yyyy")).parse(scanner.next()).getTime());
                correctValue = true;
            } catch (ParseException e) {
                System.out.println("Wrong date. Try again.");
            }
        }

        Store.devices.addDevice(deviceType, brand, model, color, price, releaseDate);
        System.out.println("Success! Device added.");
    }

    private static void findDeviceAndPrintInfoAboutIt() {
        //TODO: write some code here
    }
}
