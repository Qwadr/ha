package com.softwerke.store.model.factories;

import com.softwerke.store.model.Clients;
import com.softwerke.store.model.Devices;
import com.softwerke.store.model.Sales;
import com.softwerke.store.model.impl.ClientsImpl;
import com.softwerke.store.model.impl.DevicesImpl;
import com.softwerke.store.model.impl.SalesImpl;

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
