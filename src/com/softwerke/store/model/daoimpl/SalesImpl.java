package com.softwerke.store.model.daoimpl;

import com.softwerke.store.model.dao.Sales;
import com.softwerke.store.model.entities.Client;
import com.softwerke.store.model.entities.Device;
import com.softwerke.store.model.entities.Sale;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Implementation of "Sales" DAO interface.
 * <p>
 * This class is the main storage of all sales.
 * <p>
 * Class realizes Singleton pattern.
 * <p>
 * "addSale" method creates a new client using SaleBuilder.
 */
public class SalesImpl implements Sales {
    private static SalesImpl instance;
    private static ArrayList<Sale> sales;

    private SalesImpl() {
        sales = new ArrayList<>();
    }

    /**
     * Classical not multithreaded Singleton.
     */
    public static SalesImpl getInstance() {
        if (instance == null) {
            instance = new SalesImpl();
        }
        return instance;
    }

    /**
     * Creating a new sale using SaleBuilder.
     * @param client      - exemplar of Client
     * @param saleDate    - date of sale, java.util.Date
     * @param devices     - map of device-count pairs
     */
    @Override
    public void addSale(Client client, Date saleDate, Map<Device, Integer> devices) {
        Sale newSale = (new Sale.SaleBuilder())
                .setClient(client)
                .setSaleDate(saleDate)
                .setDevices(devices)
                .build();
        sales.add(newSale);
    }

    @Override
    public List<Sale> getListOfSales() {
        return sales;
    }
}
