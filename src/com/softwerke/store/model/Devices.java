package com.softwerke.store.model;

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

    void addDevice(DeviceType type, String brand, String model, Color color, BigDecimal price, Date releaseDate);

    List<Device> getListOfDevices();
}

