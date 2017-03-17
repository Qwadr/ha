package model;

import entities.Client;
import entities.Device;
import entities.Sale;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Qwadr on 09.03.2017 at 21:23.
 */
public class Sales {
    ArrayList<Sale> sales;

    public void addSale(Client client, Date saleDate, HashMap<Device, Integer> devices) {
        sales.add(new Sale(client, saleDate, devices));
    }

    public Sales() {
        sales = new ArrayList<>();
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }
}
