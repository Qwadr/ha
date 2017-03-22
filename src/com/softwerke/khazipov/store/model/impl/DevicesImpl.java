package com.softwerke.khazipov.store.model.impl;

import com.softwerke.khazipov.store.model.Devices;
import com.softwerke.khazipov.store.model.entities.Device;
import com.softwerke.khazipov.store.model.entities.enums.DeviceType;

import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of "Devices" DAO interface. More information will be added later.
 */

public class DevicesImpl implements Devices {
    private static ArrayList<Device> devices;

    public void addDevice(DeviceType type, String brand, String model, Color color, BigDecimal price, Date releaseDate) {
        devices.add(new Device(type, brand, model, color, price, releaseDate));
    }

    @Override
    public List<Device> getListOfDevices() {
        return devices;
    }

    @Override
    public List<Device> getSortedListOfDevices() {
        //TODO sorting
        return null;
    }

    @Override
    public Device findDevice(int ID) {
        Device existingDevices = null;
        for (Device device : devices) {
            if (device.getDeviceID() == ID) {
                existingDevices = device;
            }
        }
        return existingDevices;
    }

    public DevicesImpl() {
        devices = new ArrayList<>();
    }
}