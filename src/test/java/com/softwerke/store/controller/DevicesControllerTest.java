package com.softwerke.store.controller;

import com.softwerke.store.controller.main.InitialDataGenerator;
import com.softwerke.store.controller.main.Store;
import com.softwerke.store.model.Devices;
import com.softwerke.store.model.entities.Device;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * TODO some javadoc
 */
public class DevicesControllerTest {
    @BeforeClass
    public static void setUp() {
        InitialDataGenerator.addInitialData();
    }

    @Test
    public void findDeviceByNegativeID() throws Exception {
        Device device;
        device = DevicesController.findDeviceByID(-1);
        assertNull(device);
    }

    @Test
    public void findDeviceByPositiveID() throws Exception {
        Device device;
        device = DevicesController.findDeviceByID(1);
        assertNotNull(device);
    }

    @Test
    public void findDeviceByUncreatedID() throws Exception {
        Device device;
        device = DevicesController.findDeviceByID(Integer.MAX_VALUE);
        assertNull(device);
    }

    @Test
    public void findExistingDevicesByBrand() throws Exception {
        List<Device> devices = DevicesController.findDevicesByBrand("Lenovo");
        List<Device> devices1 = DevicesController.findDevicesByBrand("LENOVO");

        assertTrue(devices.size() > 0 && devices1.size() > 0);

        assertArrayEquals(devices.toArray(new Device[devices.size()]),
                devices1.toArray(new Device[devices1.size()]));
    }

    @Test
    public void findNotExistingDevicesByBrand() throws Exception {
        List<Device> devices;
        devices = DevicesController.findDevicesByBrand("Lenovovo");

        assertTrue(devices.size() == 0);
    }

    @Test
    public void findDeviceByType() throws Exception {
        List<Device> devices;
        devices = DevicesController.findDevicesByType("Lenovovo");
    }

    @Test
    public void findDeviceByReleaseDate() throws Exception {
    }

    @Test
    public void getListOfDevicesSortedByDeviceID() throws Exception {
    }

    @Test
    public void getListOfDevicesSortedByDeviceType() throws Exception {
    }

    @Test
    public void getListOfDevicesSortedByBrand() throws Exception {
    }

    @Test
    public void getListOfDevicesSortedByModel() throws Exception {
    }

    @Test
    public void getListOfDevicesSortedByReleaseDate() throws Exception {
    }

    @Test
    public void getListOfDevicesSortedByPrice() throws Exception {
    }

    @Test
    public void beforeClassAnnotationIsWorking() throws Exception {
        Devices devices = Store.devices;
        assertEquals(devices.getListOfDevices().size(), 3);
    }
}