package com.softwerke.store.model;

import com.softwerke.store.model.entities.Client;
import com.softwerke.store.model.entities.Device;
import com.softwerke.store.model.entities.Sale;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO interface for "Sale" entity
 */
public interface Sales {

    void addSale(Client client, Date saleDate, Map<Device, Integer> devices);

    List<Sale> getListOfSales();
}
