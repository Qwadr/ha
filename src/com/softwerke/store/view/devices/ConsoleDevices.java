package com.softwerke.store.view.devices;

import com.softwerke.store.controller.DevicesController;
import com.softwerke.store.controller.main.Store;
import com.softwerke.store.view.utils.CollectionPrinter;
import com.softwerke.store.view.utils.DateHelper;
import com.softwerke.store.model.entities.Device;
import com.softwerke.store.model.entities.enums.DeviceType;
import com.softwerke.store.view.ConsoleView;

import java.awt.Color;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

/**
 * All interaction with user about devices.
 * Main operations: create, show all, sort, find, back to main menu.
 */
public class ConsoleDevices implements ConsoleView {
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
                    ConsoleDeviceSortingDialog.start(scanner);
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
                deviceType = DeviceType.PHONE;
                break;
            case 2:
                deviceType = DeviceType.TABLET;
                break;
            case 3:
                deviceType = DeviceType.LAPTOP;
                break;
            case 4:
                deviceType = DeviceType.PLAYER;
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
        Device device;
        System.out.println("Choose operation: ");
        System.out.println("1. Find device by deviceID.");
        System.out.println("2. Find device by brand name.");
        System.out.println("3. Find device by type of device.");
        System.out.println("4. Find device by release date.");
        System.out.println("0. Step back.");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter ID: ");
                int deviceID = scanner.nextInt();
                device = DevicesController.findDeviceByID(deviceID);
                if (device != null) {
                    System.out.println("Device found. Info about it: ");
                    System.out.println(device.toString());
                } else {
                    System.out.println("We have no devices with this ID.");
                }
                break;

            case 2:
                System.out.println("Enter brand name: ");
                String brandName = scanner.next();
                List<Device> brandDevices = DevicesController.findDevicesByBrand(brandName);
                if (brandDevices.size() == 0) {
                    System.out.println("We have something for you! Here all " + brandName + " devices:");
                    System.out.println(brandDevices.toString());
                } else {
                    System.out.println("We don't have devices with this brand.");
                }
                break;

            case 3:
                System.out.println("Enter type: ");
                String type = scanner.next();
                List<Device> typeDevices = DevicesController.findDevicesByType(type); //list of devices
                if (typeDevices.size() != 0) {
                    System.out.println("We have something for you! Here all " + type + "s:");
                    CollectionPrinter.printList(typeDevices);
                } else {
                    System.out.println("We don't have devices with this type.");
                }
                break;

            case 4:
                Date releaseDate = DateHelper.readDate(scanner);
                List<Device> devicesWithThisReleaseTime = DevicesController.findDevicesByReleaseDate(releaseDate);
                if (devicesWithThisReleaseTime.size() != 0) {
                    System.out.println("We have something for you! Here all devices with this releasing date:");
                    CollectionPrinter.printList(devicesWithThisReleaseTime);
                } else {
                    System.out.println("We don't have devices with this realisation date.");
                }
                break;

            case 0:
                break;

            default:
                System.out.println("Bad number.");
        }
    }
}
