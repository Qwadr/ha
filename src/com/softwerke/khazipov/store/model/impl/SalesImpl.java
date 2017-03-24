package com.softwerke.khazipov.store.model.impl;

import com.softwerke.khazipov.store.model.Sales;
import com.softwerke.khazipov.store.model.entities.Client;
import com.softwerke.khazipov.store.model.entities.Device;
import com.softwerke.khazipov.store.model.entities.Sale;

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

    public List<Sale> getListOfSales() {
        return sales;
    }

    public static SalesImpl getInstance() {
        if (instance == null) {
            instance = new SalesImpl();
        }
        return instance;
    }
    @Override
    public List<Sale> getSortedListOfSales() {
        //TODO sorting
        return null;
    }

    @Override
    public Sale findSale(int ID) {
        Sale existingSale = null;
        for (Sale sale : sales) {
            if (sale.getSaleID() == ID) {
                existingSale = sale;
            }
        }
        return existingSale;
    }

    public void addSale(Client client, Date saleDate, Map<Device, Integer> devices) {
        sales.add(new Sale(client, saleDate, devices));
    }

    public SalesImpl() {
        sales = new ArrayList<>();
    }


}
