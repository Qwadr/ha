package model;

import model.entities.Client;
import model.entities.Device;
import model.entities.Sale;

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
