package com.softwerke.khazipov.store.controller.main;

import com.softwerke.khazipov.store.view.ConsoleMain;
import com.softwerke.khazipov.store.model.Clients;
import com.softwerke.khazipov.store.model.Devices;
import com.softwerke.khazipov.store.model.Sales;
import com.softwerke.khazipov.store.model.entities.Client;
import com.softwerke.khazipov.store.model.entities.Device;
import com.softwerke.khazipov.store.view.View;

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
