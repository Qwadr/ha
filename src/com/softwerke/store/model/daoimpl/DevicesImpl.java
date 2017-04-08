package com.softwerke.store.model.daoimpl;

import com.softwerke.store.model.dao.Devices;
import com.softwerke.store.model.entities.Device;
import com.softwerke.store.model.entities.enums.DeviceType;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of "Devices" DAO interface.
 * <p>
 * This class is the main storage of all devices.
 * <p>
 * Class realizes Singleton pattern.
 * <p>
 * "addDevice" method creates a new client using DeviceBuilder.
 */

public class DevicesImpl implements Devices {
    private static DevicesImpl instance;
    private static ArrayList<Device> devices;

    private DevicesImpl() {
        devices = new ArrayList<>();
    }

    /**
     * Classical not multithreaded Singleton.
     */
    public static DevicesImpl getInstance() {
        if (instance == null) {
            instance = new DevicesImpl();
        }
        return instance;
    }

    /**
     * Creating a new device using DeviceBuilder.
     * @param type        - type of device: LAPTOP, PHONE, PLAYER or TABLET
     * @param brand       - device brand, any String
     * @param model       - device model, any String
     * @param color       - java.awt.Color only
     * @param price       - the price of one device, BigDecimal (for high accuracy)
     * @param releaseDate - date of device issue, java.util.Date
     */
    @Override
    public void addDevice(DeviceType type, String brand, String model, Color color, BigDecimal price, Date releaseDate) {
        Device newDevice = (new Device.DeviceBuilder())
                .setType(type)
                .setBrand(brand)
                .setModel(model)
                .setColor(color)
                .setPrice(price)
                .setReleaseDate(releaseDate)
                .build();
        devices.add(newDevice);
    }

    @Override
    public List<Device> getListOfDevices() {
        return devices;
    }
}