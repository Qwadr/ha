package com.softwerke.store.model.entities;

import com.softwerke.store.model.entities.enums.DeviceType;

import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * "Device" entity.
 * Realizes Builder pattern.
 */
public class Device {
    private int deviceID;
    private Color color;
    private Date releaseDate;
    private DeviceType type;
    private String brand;
    private String model;
    private BigDecimal price;

    private static int numberOfDevices = 0;

    public Device() {
        this.deviceID = ++numberOfDevices;
    }

    public Device(DeviceBuilder builder) {
        this();
        this.color = builder.color;
        this.releaseDate = builder.releaseDate;
        this.type = builder.type;
        this.brand = builder.brand;
        this.model = builder.model;
        this.price = builder.price;
    }

    public Color getColor() {
        return color;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public DeviceType getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getFullNameOfModel() {
        return brand + " " + model;
    }

    public BigDecimal getPrice() {
        return price;
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

    public static class DeviceBuilder {
        private Color color;
        private Date releaseDate;
        private DeviceType type;
        private String brand;
        private String model;
        private BigDecimal price;

        public DeviceBuilder setColor(Color color) {
            this.color = color;
            return this;
        }

        public DeviceBuilder setReleaseDate(Date releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public DeviceBuilder setType(DeviceType type) {
            this.type = type;
            return this;
        }

        public DeviceBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public DeviceBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public DeviceBuilder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Device build() {
            return new Device(this);
        }
    }
}
