package com.softwerke.store.model.dao;

import com.softwerke.store.model.entities.Device;
import com.softwerke.store.model.entities.enums.DeviceType;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * DAO interface for "Device" entity
 */
public interface Devices {

    /**
     * Create new device.
     *
     * @param type        - type of device: LAPTOP, PHONE, PLAYER or TABLET
     * @param brand       - device brand, any String
     * @param model       - device model, any String
     * @param color       - java.awt.Color only
     * @param price       - the price of one device, BigDecimal (for high accuracy)
     * @param releaseDate - date of device issue, java.util.Date
     */
    void addDevice(DeviceType type, String brand, String model, Color color, BigDecimal price, Date releaseDate);

    /**
     * Getting a list of all devices in the system.
     */
    List<Device> getListOfDevices();
}

