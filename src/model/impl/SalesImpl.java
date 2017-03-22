package model.impl;

import model.Sales;
import model.entities.Client;
import model.entities.Device;
import model.entities.Sale;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Implementation of "Sales" DAO interface. More information will be added later.
 */
public class SalesImpl implements Sales {
    private static ArrayList<Sale> sales;

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

    public List<Sale> getListOfSales() {
        return sales;
    }
}
