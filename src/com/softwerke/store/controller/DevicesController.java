package com.softwerke.store.controller;

import com.softwerke.store.controller.main.Store;
import com.softwerke.store.model.entities.Device;
import com.softwerke.store.view.utils.DateHelper;

import java.sql.Date;
import java.util.*;
import java.util.List;

/**
 * Devices controller with realisation of search methods.
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
            if (DateHelper.datesAreInOneDay(device.getReleaseDate(), releaseDate)) {
                wantedDevices.add(device);
            }

        }
        return wantedDevices;
    }

    public static List<Device> getListOfDevicesSortedByDeviceID() {
        List<Device> allDevices = Store.devices.getListOfDevices();
        Collections.sort(allDevices, new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                return Integer.compare(o1.getDeviceID(), o2.getDeviceID());
            }
        });
        return allDevices;
    }

    public static List<Device> getListOfDevicesSortedByDeviceType() {
        List<Device> allDevices = Store.devices.getListOfDevices();
        Collections.sort(allDevices, new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                return o1.getType().compareTo(o2.getType());
            }
        });
        return allDevices;
    }

    public static List<Device> getListOfDevicesSortedByBrand() {
        List<Device> allDevices = Store.devices.getListOfDevices();
        Collections.sort(allDevices, new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                return o1.getBrand().toLowerCase().trim().compareTo(o2.getBrand().toLowerCase().trim());
            }
        });
        return allDevices;
    }

    public static List<Device> getListOfDevicesSortedByModel() {
        List<Device> allDevices = Store.devices.getListOfDevices();
        Collections.sort(allDevices, new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                String s1 = o1.getBrand() + " " + o1.getModel();
                String s2 = o2.getBrand() + " " + o2.getModel();
                return s1.compareTo(s2);
            }
        });
        return allDevices;
    }


    public static List<Device> getListOfDevicesSortedByReleaseDate() {
        List<Device> allDevices = Store.devices.getListOfDevices();
        Collections.sort(allDevices, new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                return o1.getReleaseDate().compareTo(o2.getReleaseDate());
            }
        });
        return allDevices;
    }

    public static List<Device> getListOfDevicesSortedByPrice() {
        List<Device> allDevices = Store.devices.getListOfDevices();
        Collections.sort(allDevices, new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });
        return allDevices;
    }
}
