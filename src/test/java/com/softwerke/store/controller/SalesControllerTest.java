package com.softwerke.store.controller;

import com.softwerke.store.controller.main.InitialDataGenerator;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * TODO some javadoc
 */
public class SalesControllerTest {
    @BeforeClass
    public static void setUp() {
        InitialDataGenerator.addInitialData();
    }

    @Test
    public void findSaleBySaleID() throws Exception {
    }

    @Test
    public void findSaleByDate() throws Exception {
    }

    @Test
    public void findSaleByClientID() throws Exception {
    }

    @Test
    public void getListOfSalesSortedBySaleID() throws Exception {
    }

    @Test
    public void getListOfSalesSortedByClientID() throws Exception {
    }

    @Test
    public void getListOfSalesSortedByDate() throws Exception {
    }

}