package com.softwerke.khazipov.store.model;

import com.softwerke.khazipov.store.model.entities.Client;
import com.softwerke.khazipov.store.model.entities.Device;
import com.softwerke.khazipov.store.model.entities.enums.DeviceType;

import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * DAO interface for "Device" entity
 */
public interface Devices {

    void addDevice(DeviceType type, String brand, String model, Color color, BigDecimal price, Date releaseDate);

    Device findDevice(int ID);

    List<Device> getSortedListOfDevices();

    List<Device> getListOfDevices();
}

