package com.softwerke.khazipov.store.controller;

import com.softwerke.khazipov.store.model.entities.Device;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Devices com.softwerke.khazipov.store.controller without realisation.
 */
public class DevicesController {
    public static List<Device> getSortedListOfDevices(int DeviceID) {

        return null;
    }

    public static Device findDeviceByID(int DeviceID) {

        return null;
    }

    public static List<Device> findDeviceByBrand(String brandName) {
        //TODO searching
        return new ArrayList<>();
    }

    public static List<Device> findDeviceByType(String type) {
        //TODO searching
        return new ArrayList<>();
    }

    public static List<Device> findDeviceByReleaseDate(Date releaseDate) {
        //TODO searching
        return new ArrayList<>();
    }
}
