package com.softwerke.store.model.impl;

import com.softwerke.store.model.Devices;
import com.softwerke.store.model.entities.Device;
import com.softwerke.store.model.entities.enums.DeviceType;

import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of "Devices" DAO interface. More information will be added later.
 */

public class DevicesImpl implements Devices {
    private static DevicesImpl instance;
    private static ArrayList<Device> devices;

    private DevicesImpl() {
        devices = new ArrayList<>();
    }

    public static DevicesImpl getInstance() {
        if (instance == null) {
            instance = new DevicesImpl();
        }
        return instance;
    }

    public void addDevice(DeviceType type, String brand, String model, Color color, BigDecimal price, Date releaseDate) {
        devices.add(new Device(type, brand, model, color, price, releaseDate));
    }

    @Override
    public List<Device> getListOfDevices() {
        return devices;
    }

}