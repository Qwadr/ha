package com.softwerke.khazipov.store.view.utils;

import java.util.List;

/**
 * Supporting view class that provides logic of collection printing.
 */
public class CollectionPrinter {

    public static void printList(List source) {
        for (Object item : source) {
            System.out.println(item.toString());
        }
    }

    public static void printList(List source, String headString) {
        System.out.println(headString);
        printList(source);
    }
}
