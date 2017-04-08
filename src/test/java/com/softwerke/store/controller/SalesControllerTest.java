package com.softwerke.store.controller;

import com.softwerke.store.controller.main.InitialDataGenerator;
import com.softwerke.store.model.entities.Sale;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

public class SalesControllerTest {
    @BeforeClass
    public static void setUp() {
        InitialDataGenerator.addInitialData();
    }

    @Test
    public void findExistingSaleBySaleID() throws Exception {
        Sale sale;
        sale = SalesController.findSaleBySaleID(1);
        assertNotNull(sale);
    }

    @Test
    public void findNotExistingSaleBySaleID() throws Exception {
        Sale sale;

        sale = SalesController.findSaleBySaleID(Integer.MAX_VALUE);
        assertNull(sale);

        sale = SalesController.findSaleBySaleID(-1000);
        assertNull(sale);
    }


    @Test
    public void findExistingSalesByDate() throws Exception {
        List<Sale> sales;
        Date dateOfSale = new Date((new SimpleDateFormat("dd-MM-yyyy")).parse("11-11-1950").getTime());
        sales = SalesController.findSalesByDate(dateOfSale);

        assertTrue(sales.size() > 0);
    }

    @Test
    public void findNotExistingSalesByDate() throws Exception {
        List<Sale> sales;
        Date dateOfSale = new Date((new SimpleDateFormat("dd-MM-yyyy")).parse("11-11-1111").getTime());
        sales = SalesController.findSalesByDate(dateOfSale);

        assertTrue(sales.size() == 0);
    }

    @Test
    public void findExistingSalesByClientID() throws Exception {
        List<Sale> sales;
        sales = SalesController.findSalesByClientID(3);

        assertTrue(sales.size() > 0);
    }

    @Test
    public void findNotExistingSalesByClientID() throws Exception {
        List<Sale> sales;
        sales = SalesController.findSalesByClientID(-1);

        assertTrue(sales.size() == 0);
    }

    @Test
    public void getListOfSalesSortedBySaleID() throws Exception {
        boolean resultIsCorrect = true;
        List<Sale> sortedSales = SalesController.getListOfSalesSortedBySaleID();
        for (int i = 0; i < sortedSales.size() - 1; i++) {
            if (sortedSales.get(i).getSaleID() > sortedSales.get(i + 1).getSaleID()) {
                resultIsCorrect = false;
            }
        }
        assertTrue(resultIsCorrect);
    }

    @Test
    public void getListOfSalesSortedByClientID() throws Exception {
        boolean resultIsCorrect = true;
        List<Sale> sortedSales = SalesController.getListOfSalesSortedByClientID();
        for (int i = 0; i < sortedSales.size() - 1; i++) {
            if (sortedSales.get(i).getClient().getClientID()
                    > sortedSales.get(i + 1).getClient().getClientID()) {
                resultIsCorrect = false;
            }
        }
        assertTrue(resultIsCorrect);
    }

    @Test
    public void getListOfSalesSortedByDate() throws Exception {
        boolean resultIsCorrect = true;
        List<Sale> sortedSales = SalesController.getListOfSalesSortedByDate();
        for (int i = 0; i < sortedSales.size() - 1; i++) {
            if (sortedSales.get(i).getSaleDate()
                    .compareTo(sortedSales.get(i + 1).getSaleDate()) > 0) {
                resultIsCorrect = false;
            }
        }
        assertTrue(resultIsCorrect);
    }

}