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

    /**
     * Create new sale.
     *
     * @param client      - exemplar of Client
     * @param saleDate    - date of sale, java.util.Date
     * @param devices     - map of device-count pairs
     */
    void addSale(Client client, Date saleDate, Map<Device, Integer> devices);

    /**
     * Getting a list of all sales in the system.
     */
    List<Sale> getListOfSales();
}
