package com.softwerke.store.model.factories;

import com.softwerke.store.model.dao.Clients;
import com.softwerke.store.model.dao.Devices;
import com.softwerke.store.model.dao.Sales;
import com.softwerke.store.model.daoimpl.ClientsImpl;
import com.softwerke.store.model.daoimpl.DevicesImpl;
import com.softwerke.store.model.daoimpl.SalesImpl;

/**
 * Class outputs realisations of three main interfaces.
 */
public class DAOFactory {
    public static Clients getExemplarOfClientsClass() {
        return ClientsImpl.getInstance();
    }

    public static Devices getExemplarOfDevicesClass() {
        return DevicesImpl.getInstance();
    }

    public static Sales getExemplarOfSalesClass() {
        return SalesImpl.getInstance();
    }
}
