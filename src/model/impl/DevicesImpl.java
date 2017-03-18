package model.impl;

import model.Devices;
import model.entities.Device;
import model.entities.enums.DeviceType;

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

    public DevicesImpl() {
        devices = new ArrayList<>();
    }
}