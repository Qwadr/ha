package model.impl;

import model.entities.Device;
import model.entities.enums.DeviceType;

import java.awt.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Implementation of "Devices" DAO interface. More information will be added later.
 */

public class DevicesImpl {
    private ArrayList<Device> devices;

    public void addDevice(DeviceType type, String brand, String model, Color color, BigDecimal price, Date releaseDate) {
        devices.add(new Device(type, brand, model, color, price, releaseDate));
    }

    public DevicesImpl() {
        devices = new ArrayList<>();
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }
}
