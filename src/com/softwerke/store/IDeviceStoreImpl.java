package com.softwerke.store;

import com.softwerke.store.controller.ClientsController;
import com.softwerke.store.controller.DevicesController;
import com.softwerke.store.controller.SalesController;
import com.softwerke.store.controller.main.Store;
import com.softwerke.store.model.entities.Client;
import com.softwerke.store.model.entities.Device;
import com.softwerke.store.model.entities.Sale;
import com.softwerke.store.model.entities.enums.DeviceType;

import java.awt.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

/**
 * Implementation of IDeviceStore interface.
 */
public class IDeviceStoreImpl implements IDeviceStore {
    @Override
    public void addClient(String lastName, String firstName, String middleName, java.util.Date birthDate) {
        Store.clients.addClient(firstName, lastName, middleName, birthDate);
    }

    @Override
    public void addDevice(String type, String brand, String model, Color color, java.util.Date issueDate) {
        DeviceType deviceType = DeviceType.getDeviceType(type);
        Store.devices.addDevice(deviceType, brand, model, color, new BigDecimal(0), issueDate);
    }

    @Override
    public void addSale(java.util.Date saleDate, Integer clientId, Map<Integer, Integer> deviceIdAndQuantity) {
        Client client = ClientsController.findClientByID(clientId);
        Map<Device, Integer> deviceMap = new HashMap<>();

        for (Integer deviceID : deviceIdAndQuantity.keySet()) { //Map<Integer, Integer> -> Map <Device, Integer>
            Device device = DevicesController.findDeviceByID(deviceID);
            deviceMap.put(device, deviceIdAndQuantity.get(deviceID));
        }

        Store.sales.addSale(client, saleDate, deviceMap);
    }

    @Override
    public void searchClientsByName(String name) {
        List<Client> clients = ClientsController.findClientsByPartOfFullName(name);
    }

    @Override
    public void searchDevicesByIssueDate(java.util.Date issueDate) {
        List<Device> devices = DevicesController.findDevicesByReleaseDate(issueDate);
    }

    @Override
    public void sortClientsByName() {
        List<Client> sortedClients = ClientsController.getListOfClientsSortedByFullName();
    }

    @Override
    public void sortDevicesByModel() {
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByModel();
    }

    @Override
    public void sortSalesByDate() {
        List<Sale> sortedSales = SalesController.getListOfSalesSortedByDate();
    }
}
