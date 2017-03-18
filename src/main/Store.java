package main;

import console.ConsoleImpl;
import model.Clients;
import model.Devices;
import model.Sales;
import model.entities.Client;
import model.entities.Device;
import model.entities.enums.DeviceType;
import model.factories.DAOFactory;

import java.awt.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

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

        console.start();

    }

    static {
        clients = DAOFactory.getExemplarOfClientsClass();
        devices = DAOFactory.getExemplarOfDevicesClass();
        sales = DAOFactory.getExemplarOfSalesClass();

        try {
            clients.addClient("Anton", "Antonov", "Antonovich",
                    new Date(System.currentTimeMillis()));

            clients.addClient("Ivan", "Ivanov", "Ivanovich",
                    new Date((new SimpleDateFormat("dd-MM-yyyy")).parse("10-10-1900").getTime()));

            clients.addClient("Petr", "Petrovich", "Petrovich",
                    new Date((new SimpleDateFormat("dd-MM-yyyy")).parse("11-11-1800").getTime()));

            devices.addDevice(DeviceType.WALKMAN, "Sony", "Walkman UBER9000", Color.white,
                    new BigDecimal(100500), new Date(System.currentTimeMillis()));

            devices.addDevice(DeviceType.LAPTOP, "Lenovo", "IdeaPad L322", Color.black,
                    new BigDecimal(100501), new Date(System.currentTimeMillis()));

            devices.addDevice(DeviceType.TABLET, "ASUS", "number 88005553535", Color.blue,
                    new BigDecimal(100499), new Date(System.currentTimeMillis()));

            HashMap<Device, Integer> devices = new HashMap<>();
            devices.put(findDevice(1), 2);
            devices.put(findDevice(2), 4);
            devices.put(findDevice(3), 7); // 13 devices summary
            sales.addSale(findClient(1), new Date(System.currentTimeMillis()), devices);
        } catch (Exception ignored) {
        }

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
