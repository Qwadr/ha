package model.factories;

import model.Clients;
import model.Devices;
import model.Sales;
import model.impl.ClientsImpl;
import model.impl.DevicesImpl;
import model.impl.SalesImpl;

/**
 * Class outputs realisations of three controller.main interfaces.
 */
public class DAOFactory {
    public static Clients getExemplarOfClientsClass() {
        return new ClientsImpl();
    }

    public static Devices getExemplarOfDevicesClass() {
        return new DevicesImpl();
    }

    public static Sales getExemplarOfSalesClass() {
        return new SalesImpl();
    }
}
