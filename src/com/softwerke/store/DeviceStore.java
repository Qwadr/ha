package com.softwerke.store;

import com.softwerke.store.controller.main.InitialDataGenerator;

public class DeviceStore {

    public static void main(String[] args) {
        InitialDataGenerator.addInitialData();
        IDeviceStore iDeviceStore = getDeviceStore();
    }

    public static IDeviceStore getDeviceStore() {
        return new IDeviceStoreImpl();
    }

}