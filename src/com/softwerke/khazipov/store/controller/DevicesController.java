package com.softwerke.khazipov.store.controller;

import com.softwerke.khazipov.store.controller.main.Store;
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
        Device wantedDevice = null;
        List<Device> allDevices = Store.devices.getListOfDevices();

        for (Device device : allDevices) {
            if (device.getDeviceID() == DeviceID) {
                wantedDevice = device;
                break;
            }
        }
        return wantedDevice;
    }

    public static List<Device> findDeviceByBrand(String brandName) {
        List<Device> wantedDevices = new ArrayList<>();
        List<Device> allDevices = Store.devices.getListOfDevices();

        for (Device device : allDevices) {
            if (device.getBrand().toLowerCase().trim().equals(brandName.toLowerCase().trim())) {
                wantedDevices.add(device);
            }
        }
        return wantedDevices;
    }

    public static List<Device> findDeviceByType(String type) {
        List<Device> wantedDevices = new ArrayList<>();
        List<Device> allDevices = Store.devices.getListOfDevices();

        for (Device device : allDevices) {
            if (device
                    .getType()
                    .toString()
                    .toLowerCase()
                    .equals(type
                            .toLowerCase()
                            .trim())) {
                wantedDevices.add(device);
            }
        }
        return wantedDevices;
    }

    public static List<Device> findDeviceByReleaseDate(Date releaseDate) {
        List<Device> wantedDevices = new ArrayList<>();
        List<Device> allDevices = Store.devices.getListOfDevices();

        for (Device device : allDevices) {
            if (device.getReleaseDate() == releaseDate) {
                wantedDevices.add(device);
            }
        }
        return wantedDevices;
    }
}
