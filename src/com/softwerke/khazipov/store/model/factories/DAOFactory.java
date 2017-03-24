package com.softwerke.khazipov.store.model.factories;

import com.softwerke.khazipov.store.model.Clients;
import com.softwerke.khazipov.store.model.Devices;
import com.softwerke.khazipov.store.model.Sales;
import com.softwerke.khazipov.store.model.impl.ClientsImpl;
import com.softwerke.khazipov.store.model.impl.DevicesImpl;
import com.softwerke.khazipov.store.model.impl.SalesImpl;

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
