package com.softwerke.khazipov.store.model;

import com.softwerke.khazipov.store.model.entities.Client;
import com.softwerke.khazipov.store.model.entities.Device;
import com.softwerke.khazipov.store.model.entities.Sale;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO interface for "Sale" entity
 */
public interface Sales {

    void addSale(Client client, Date saleDate, Map<Device, Integer> devices);

    Sale findSale (int ID);

    List<Sale> getListOfSales();
}
