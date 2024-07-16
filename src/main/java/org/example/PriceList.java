package org.example;

import java.util.HashMap;
import java.util.Map;

public class PriceList extends HashMap<Integer, Item> {
    private static PriceList priceList;

    public static PriceList newPriceList() {
        if (priceList == null) {
            priceList = new PriceList();
        }
        return priceList;

    }

    public void addItem(Item item) {
        priceList.put(item.itemId, item);
    }

    public void showPriceList() {
        for (Map.Entry<Integer, Item> entry : priceList.entrySet()) {
            Integer key = entry.getKey();
            Item value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }


    //TODO
    public void showGroupValues(int groupId) {
        for (Map.Entry<Integer, Item> entry : priceList.entrySet()) {
            Integer key = entry.getKey();
            Item value = entry.getValue();
            if (value.itemGroup == groupId) {
                System.out.println(key + " " + value);
            }
        }
    }

    //TODO
    public Item getItem(int i) {
        return priceList.get(i);
    }
}
