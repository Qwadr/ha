package controller.main;

import model.Clients;
import model.Devices;
import model.Sales;
import model.entities.Device;
import model.entities.enums.DeviceType;
import model.factories.DAOFactory;

import java.awt.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * Creating system state at start of our program.
 */
public class InitialDataGenerator {
    private static Clients clients;
    private static Devices devices;
    private static Sales sales;

    public static void addInitialData() {
        Store.clients = DAOFactory.getExemplarOfClientsClass();
        Store.devices = DAOFactory.getExemplarOfDevicesClass();
        Store.sales = DAOFactory.getExemplarOfSalesClass();
        clients = Store.clients;
        devices = Store.devices;
        sales = Store.sales;

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
            devices.put(Store.findDevice(1), 2);
            devices.put(Store.findDevice(2), 4);
            devices.put(Store.findDevice(3), 7); // 13 devices summary
            sales.addSale(Store.findClient(1), new Date(System.currentTimeMillis()), devices);
        } catch (Exception ignored) {
        }
    }

}
