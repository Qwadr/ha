package com.softwerke.store.model.impl;

import com.softwerke.store.model.Sales;
import com.softwerke.store.model.entities.Client;
import com.softwerke.store.model.entities.Device;
import com.softwerke.store.model.entities.Sale;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Implementation of "Sales" DAO interface. More information will be added later.
 */
public class SalesImpl implements Sales {
    private static SalesImpl instance;
    private static ArrayList<Sale> sales;

    private SalesImpl() {
        sales = new ArrayList<>();
    }

    public static SalesImpl getInstance() {
        if (instance == null) {
            instance = new SalesImpl();
        }
        return instance;
    }

    public List<Sale> getListOfSales() {
        return sales;
    }

    public void addSale(Client client, Date saleDate, Map<Device, Integer> devices) {
        sales.add(new Sale(client, saleDate, devices));
    }


}
