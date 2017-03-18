package model.impl;

import model.entities.Client;
import model.entities.Device;
import model.entities.Sale;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

/**
 * Implementation of "Sales" DAO interface. More information will be added later.
 */
public class SalesImpl {
    private ArrayList<Sale> sales;

    public void addSale(Client client, Date saleDate, Map<Device, Integer> devices) {
        sales.add(new Sale(client, saleDate, devices));
    }

    public SalesImpl() {
        sales = new ArrayList<>();
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }
}
