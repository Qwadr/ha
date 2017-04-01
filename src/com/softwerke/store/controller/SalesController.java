package com.softwerke.store.controller;

import com.softwerke.store.controller.main.Store;
import com.softwerke.store.model.entities.Sale;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sales controller with realisation of search methods.
 */
public class SalesController {
    public static Sale findSaleBySaleID(int saleID) {
        Sale wantedSale = null;
        List<Sale> allSales = Store.sales.getListOfSales();

        for (Sale sale : allSales) {
            if (sale.getSaleID() == saleID) {
                wantedSale = sale;
                break;
            }
        }
        return wantedSale;
    }


    public static List<Sale> findSaleByDate(Date date) {
        List<Sale> wantedSales = new ArrayList<>();
        List<Sale> allSales = Store.sales.getListOfSales();

        for (Sale sale : allSales) {
            if (sale.getSaleDate() == date) {
                wantedSales.add(sale);
            }
        }
        return wantedSales;
    }

    public static List<Sale> findSaleByClientID(int clientID) {
        List<Sale> wantedSales = new ArrayList<>();
        List<Sale> allSales = Store.sales.getListOfSales();

        for (Sale sale : allSales) {
            if (sale.getClient().getClientID() == clientID) {
                wantedSales.add(sale);
            }
        }
        return wantedSales;
    }

    public static List<Sale> getListOfSalesSortedBySaleID() {
        List<Sale> allSales = Store.sales.getListOfSales();
        Collections.sort(allSales, new Comparator<Sale>() {
            @Override
            public int compare(Sale o1, Sale o2) {
                return Integer.compare(o1.getSaleID(), o2.getSaleID());
            }
        });
        return allSales;
    }


    public static List<Sale> getListOfSalesSortedByClientID() {
        List<Sale> allSales = Store.sales.getListOfSales();
        Collections.sort(allSales, new Comparator<Sale>() {
            @Override
            public int compare(Sale o1, Sale o2) {
                return Integer.compare(
                        o1.getClient().getClientID(),
                        o2.getClient().getClientID()
                );
            }
        });
        return allSales;
    }

    public static List<Sale> getListOfSalesSortedByDate() {
        List<Sale> allSales = Store.sales.getListOfSales();
        Collections.sort(allSales, new Comparator<Sale>() {
            @Override
            public int compare(Sale o1, Sale o2) {
                return o1.getSaleDate().compareTo(o2.getSaleDate());
            }
        });
        return allSales;
    }
}
