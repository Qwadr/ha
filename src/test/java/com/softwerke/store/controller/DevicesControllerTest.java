package com.softwerke.store.controller;

import com.softwerke.store.controller.main.InitialDataGenerator;
import com.softwerke.store.controller.main.Store;
import com.softwerke.store.model.Devices;
import com.softwerke.store.model.entities.Device;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
    public void findExistingDevicesByType() throws Exception {
        List<Device> devices;
        devices = DevicesController.findDevicesByType("Laptop");
        assertTrue(devices.size() > 0);
    }

    @Test
    public void findNotExistingDevicesByType() throws Exception {
        List<Device> devices;
        devices = DevicesController.findDevicesByType("TopLaptop");
        assertTrue(devices.size() == 0);
    }
    
    @Test
    public void findExistingDevicesByReleaseDate() throws Exception {
        List<Device> devices;
        Date releaseDate = new Date(System.currentTimeMillis());
        devices = DevicesController.findDevicesByReleaseDate(releaseDate);
        assertTrue(devices.size() > 0);
    }

    @Test
    public void findNotExistingDevicesByReleaseDate() throws Exception {
        List<Device> devices;
        Date releaseDate = new Date(
                (new SimpleDateFormat("dd-MM-yyyy")).parse("11-11-1111").getTime());
        devices = DevicesController.findDevicesByReleaseDate(releaseDate);
        assertTrue(devices.size() == 0);
    }

    @Test
    public void getListOfDevicesSortedByDeviceID() throws Exception {
        boolean resultIsCorrect = true;
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByDeviceID();
        for (int i = 0; i < sortedDevices.size() - 1; i++) {
            if (sortedDevices.get(i).getDeviceID() > sortedDevices.get(i + 1).getDeviceID()) {
                resultIsCorrect = false;
            }
        }
        assertTrue(resultIsCorrect);
    }

    @Test
    public void getListOfDevicesSortedByDeviceType() throws Exception {
        boolean resultIsCorrect = true;
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByDeviceType();
        for (int i = 0; i < sortedDevices.size() - 1; i++) {
            if (sortedDevices.get(i).getType()
                    .compareTo(sortedDevices.get(i + 1).getType()) > 0) {
                resultIsCorrect = false;
            }
        }
        assertTrue(resultIsCorrect);
    }

    @Test
    public void getListOfDevicesSortedByBrand() throws Exception {
        boolean resultIsCorrect = true;
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByBrand();
        for (int i = 0; i < sortedDevices.size() - 1; i++) {
            if (sortedDevices.get(i).getBrand()
                    .compareTo(sortedDevices.get(i + 1).getBrand()) > 0) {
                resultIsCorrect = false;
            }
        }
        assertTrue(resultIsCorrect);
    }

    @Test
    public void getListOfDevicesSortedByModel() throws Exception {
        boolean resultIsCorrect = true;
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByModel();
        for (int i = 0; i < sortedDevices.size() - 1; i++) {
            if (sortedDevices.get(i).getFullNameOfModel()
                    .compareTo(sortedDevices.get(i + 1).getFullNameOfModel()) > 0) {
                resultIsCorrect = false;
            }
        }
        assertTrue(resultIsCorrect);
    }

    @Test
    public void getListOfDevicesSortedByReleaseDate() throws Exception {
        boolean resultIsCorrect = true;
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByReleaseDate();
        for (int i = 0; i < sortedDevices.size() - 1; i++) {
            if (sortedDevices.get(i).getReleaseDate()
                    .compareTo(sortedDevices.get(i + 1).getReleaseDate()) > 0) {
                resultIsCorrect = false;
            }
        }
        assertTrue(resultIsCorrect);
    }

    @Test
    public void getListOfDevicesSortedByPrice() throws Exception {
        boolean resultIsCorrect = true;
        List<Device> sortedDevices = DevicesController.getListOfDevicesSortedByPrice();
        for (int i = 0; i < sortedDevices.size() - 1; i++) {
            if (sortedDevices.get(i).getPrice()
                    .compareTo(sortedDevices.get(i + 1).getPrice()) > 0) {
                resultIsCorrect = false;
            }
        }
        assertTrue(resultIsCorrect);
    }

    @Test
    public void beforeClassAnnotationIsWorking() throws Exception {
        Devices devices = Store.devices;
        assertEquals(devices.getListOfDevices().size(), 4);
    }
}