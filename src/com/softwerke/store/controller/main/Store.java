package com.softwerke.store.controller.main;

import com.softwerke.store.view.ConsoleMain;
import com.softwerke.store.model.dao.Clients;
import com.softwerke.store.model.dao.Devices;
import com.softwerke.store.model.dao.Sales;

import java.text.ParseException;

/**
 * Entry point of the application.
 */
public class Store {
    public static Clients clients;
    public static Devices devices;
    public static Sales sales;

    public static void main(String[] args) throws ParseException {
        ConsoleMain console = new ConsoleMain();

        InitialDataGenerator.addInitialData();

        console.start();
    }
}
