package com.softwerke.store.controller.main;

import com.softwerke.store.controller.ClientsController;
import com.softwerke.store.controller.DevicesController;
import com.softwerke.store.model.Clients;
import com.softwerke.store.model.Devices;
import com.softwerke.store.model.Sales;
import com.softwerke.store.model.entities.Device;
import com.softwerke.store.model.entities.enums.DeviceType;
import com.softwerke.store.model.factories.DAOFactory;

import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
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
            clients.addClient("Aydar", "Evteev", "Zakirovich",
                    new Date(System.currentTimeMillis()));

            clients.addClient("Christina", "Dalevskaya", "Yanovna",
                    new Date((new SimpleDateFormat("dd-MM-yyyy")).parse("10-10-1900").getTime()));

            clients.addClient("Boris", "Fadeev", "Xavierovich",
                    new Date((new SimpleDateFormat("dd-MM-yyyy")).parse("11-11-1800").getTime()));

            clients.addClient("Ivan", "Ivanov", "Ivanovich",
                    new Date((new SimpleDateFormat("dd-MM-yyyy")).parse("11-11-1952").getTime()));

            clients.addClient("Ivan", "Ivanov", "Ivanovich",
                    new Date((new SimpleDateFormat("dd-MM-yyyy")).parse("11-11-1950").getTime()));

            devices.addDevice(DeviceType.PLAYER, "Sony", "Walkman UBER9000", Color.white,
                    new BigDecimal(100500), new Date(System.currentTimeMillis()));

            devices.addDevice(DeviceType.LAPTOP, "Lenovo", "IdeaPad L323", Color.black,
                    new BigDecimal(1005010), new Date(System.currentTimeMillis()));

            devices.addDevice(DeviceType.TABLET, "ASUS", "number 88005553535", Color.blue,
                    new BigDecimal(100499), new Date(System.currentTimeMillis()));

            devices.addDevice(DeviceType.LAPTOP, "Lenovo", "IdeaPad L322", Color.green,
                    new BigDecimal(100501), new Date(System.currentTimeMillis()));

            HashMap<Device, Integer> devices = new HashMap<>();
            devices.put(DevicesController.findDeviceByID(1), 2);
            devices.put(DevicesController.findDeviceByID(2), 4);
            devices.put(DevicesController.findDeviceByID(3), 7); // 13 devices summary

            sales.addSale(ClientsController.findClientByID(1),
                    new Date(System.currentTimeMillis()), devices);

            devices = new HashMap<>();
            devices.put(DevicesController.findDeviceByID(1), 1);
            devices.put(DevicesController.findDeviceByID(2), 3);
            devices.put(DevicesController.findDeviceByID(3), 17);
            devices.put(DevicesController.findDeviceByID(4), 27); // 48 devices summary
            Date dateOfSecondSale = new Date((new SimpleDateFormat("dd-MM-yyyy")).parse("11-11-1950").getTime());

            sales.addSale(ClientsController.findClientByID(3), dateOfSecondSale, devices);

        } catch (ParseException ignoredBecauseAllDataIsCorrect) {
            //ignored
        }
    }

}
