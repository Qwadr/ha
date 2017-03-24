package com.softwerke.khazipov.store.controller;

import com.softwerke.khazipov.store.controller.main.Store;
import com.softwerke.khazipov.store.model.entities.Sale;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Sales com.softwerke.khazipov.store.controller without realisation.
 */
public class SalesController {
    public static List<Sale> getSortedListOfSales(int SaleID) {
        //TODO: write some code here
        return null;
    }

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
}
