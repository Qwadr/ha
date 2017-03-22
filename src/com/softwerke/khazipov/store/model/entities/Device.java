package com.softwerke.khazipov.store.model.entities;

import com.softwerke.khazipov.store.model.entities.enums.DeviceType;

import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * "Device" entity. More information will be added later.
 */
public class Device {
    private int deviceID;
    private Color color;
    private Date releaseDate;
    private DeviceType type;
    private String brand;
    private String model;
    private BigDecimal price;

    private static int numberOfDevices;

    public Device(DeviceType type, String brand, String model, Color color, BigDecimal price, Date releaseDate) {
        this.deviceID = ++numberOfDevices;
        this.color = color;
        this.releaseDate = releaseDate;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public int getDeviceID() {
        return deviceID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Device ");
        sb.append("ID = ").append(deviceID);
        sb.append("; Model: ")
                .append(brand).append(" ")
                .append(model).append("; ")
                .append("price: ").append(price).append(" RUR; ")
                .append("release date: ")
                .append((new SimpleDateFormat("dd.MM.yyyy")).format(releaseDate
                ))
                .append(".");
        return sb.toString();
    }


}
