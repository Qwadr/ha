package model.entities;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;

/**
 * "Sale" entity. More information will be added later.
 */
public class Sale {
    private int saleID;
    private Date saleDate;
    private Map<Device, Integer> devices;
    private Client client;

    private static int numberOfSales;

    public Sale(Client client, Date saleDate, Map<Device, Integer> devices) {
        this.saleID = ++numberOfSales;
        this.saleDate = saleDate;
        this.devices = devices;
        this.client = client;
    }

    public int getSaleID() {

        return saleID;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Sale ");
        sb.append("ID = ").append(saleID);
        sb.append("; number of devices: ")
                .append(sumOf(devices.values())).append("; ")
                .append("sale date: ")
                .append((new SimpleDateFormat("dd.MM.yyyy")).format(saleDate))
                .append(".");
        return sb.toString();
    }

    private int sumOf(Collection<Integer> values) {
        int ans = 0;
        for (Integer num : values) {
            ans += num;
        }
        return ans;
    }

}
