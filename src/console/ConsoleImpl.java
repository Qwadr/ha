package console;

import entities.Client;
import entities.Device;
import entities.Sale;
import entities.enums.DeviceType;
import main.App;

import java.awt.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Qwadr on 09.03.2017 at 21:18.
 */
public class ConsoleImpl {
    private boolean running;
    static Scanner scanner;

    public void start() {
        scanner = new Scanner(System.in);
        running = true;
        System.out.println("Hello! Glad to see you in our imaginary store!");
        while (running) {
            System.out.println("List of opportunities:");
            System.out.println("1. Create new client.");
            System.out.println("2. Create new device.");
            System.out.println("3. Create new sale.");
            System.out.println("4. Print all info.");
            System.out.println("0. Quit.");

            System.out.println("Choose your destiny: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    readDataAndCreateNewClient();
                    break;
                case 2:
                    readDataAndCreateNewDevice();
                    break;
                case 3:
                    readDataAndCreateNewSale();
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

        System.out.println("We have " + App.clients.getClients().size() + " clients: ");
        for (Client client : App.clients.getClients()) {
            System.out.println(client.toString());
        }

        System.out.println("We have " + App.devices.getDevices().size() + " devices: ");
        for (Device device : App.devices.getDevices()) {
            System.out.println(device.toString());
        }

        System.out.println("We have " + App.sales.getSales().size() + " sales: ");
        for (Sale sale : App.sales.getSales()) {
            System.out.println(sale.toString());
        }

    }

    private void readDataAndCreateNewClient() {
        System.out.println("First name: ");
        String firstName = scanner.next();

        System.out.println("Second name: ");
        String secondName = scanner.next();

        System.out.println("Third name: ");
        String thirdName = scanner.next();

        Date birthDate = null;

        boolean correctValue = false;
        while (!correctValue) {
            try {
                System.out.println("Birthday date (in \"dd-mm-yyyy\" format): ");
                birthDate = new Date(
                        (new SimpleDateFormat("dd-MM-yyyy")).parse(scanner.next()).getTime());
                correctValue = true;
            } catch (ParseException e) {
                System.out.println("Wrong date. Try again.");
            }
        }

        App.clients.addClient(firstName, secondName, thirdName, birthDate);
        System.out.println("Success! Client added.");
    }

    private void readDataAndCreateNewDevice() {
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

        App.devices.addDevice(deviceType, brand, model, color, price, releaseDate);
        System.out.println("Success! Device added.");
    }

    private void readDataAndCreateNewSale() {
        boolean correctValue = false;
        Client client = null;
        while (!correctValue) {
            System.out.println("Client ID: ");
            int clientID = scanner.nextInt();
            client = App.findClient(clientID);
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
        HashMap<Device, Integer> devices = new HashMap<>();
        while (deviceID != 0) {
            count = scanner.nextInt();
            Device currentDevice = App.findDevice(deviceID);
            int currentCount = devices.getOrDefault(deviceID, 0);
            devices.put(currentDevice, currentCount + count);

            deviceID = scanner.nextInt();
        }


        App.sales.addSale(client, saleDate, devices);
        System.out.println("Success! Sale added.");
    }


}
