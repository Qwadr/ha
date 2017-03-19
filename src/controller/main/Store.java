package controller.main;

import view.ConsoleImpl;
import model.Clients;
import model.Devices;
import model.Sales;
import model.entities.Client;
import model.entities.Device;

import java.text.ParseException;

/**
 * Main class of the application.
 */
public class Store {
    static boolean running = true;
    public static Clients clients;
    public static Devices devices;
    public static Sales sales;

    public static void main(String[] args) throws ParseException {
        ConsoleImpl console = new ConsoleImpl();

        InitialDataGenerator.addInitialData();

        console.start();
    }

    public static Client findClient(int clientID) {
        for (Client client : Store.clients.getListOfClients()) {
            if (client.getClientID() == clientID) {
                return client;
            }
        }
        return null;
    }

    public static Device findDevice(int deviceID) {
        for (Device device : Store.devices.getListOfDevices()) {
            if (device.getDeviceID() == deviceID) {
                return device;
            }
        }
        return null;
    }

}
