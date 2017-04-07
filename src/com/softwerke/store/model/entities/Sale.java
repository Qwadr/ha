package com.softwerke.store.model.entities;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * "Sale" entity.
 * Realizes Builder pattern.
 */
public class Sale {
    private int saleID;
    private Date saleDate;
    private Map<Device, Integer> devices;
    private Client client;

    private static int numberOfSales = 0;

    public Sale() {
        this.saleID = ++numberOfSales;
    }

    public Sale(SaleBuilder builder) {
        this();
        this.saleDate = builder.saleDate;
        this.devices = builder.devices;
        this.client = builder.client;
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

    public Date getSaleDate() {
        return saleDate;
    }

    public Client getClient() {
        return client;
    }

    public static class SaleBuilder {
        private Date saleDate;
        private Map<Device, Integer> devices;
        private Client client;

        public SaleBuilder setSaleDate(Date saleDate) {
            this.saleDate = saleDate;
            return this;
        }

        public SaleBuilder setDevices(Map<Device, Integer> devices) {
            this.devices = devices;
            return this;
        }

        public SaleBuilder setClient(Client client) {
            this.client = client;
            return this;
        }

        public Sale build() {
            return new Sale(this);
        }
    }

    @Override
    protected Sale clone() throws CloneNotSupportedException {
        Sale copyOfSale = (Sale) super.clone();

        copyOfSale.saleID = this.saleID;
        copyOfSale.saleDate = (Date)this.saleDate.clone();
        copyOfSale.devices = this.devices.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        copyOfSale.client = this.client.clone();

        return copyOfSale;
    }
}
