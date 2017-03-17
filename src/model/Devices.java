package model;

import entities.Device;
import entities.enums.DeviceType;

import java.awt.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Qwadr on 09.03.2017 at 21:23.
 */

public class Devices {
    ArrayList<Device> devices;

    public void addDevice(DeviceType type, String brand, String model, Color color, BigDecimal price, Date releaseDate) {
        devices.add(new Device(type, brand, model, color, price, releaseDate));
    }

    public Devices() {
        devices = new ArrayList<>();
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }
}
