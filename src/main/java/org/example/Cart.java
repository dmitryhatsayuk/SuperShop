package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Cart {
    HashMap<Item, Integer> cart = new HashMap<>();
    PriceList priceList = PriceList.newPriceList();

    public void addToCart(Item item, int count) {

        if (cart.containsKey(item)) {
            cart.replace(item, cart.get(item) + count);
        } else cart.put(item, count);

    }

    public void showCart() {
        int sum = 0;
        for (Map.Entry<Item, Integer> entry : cart.entrySet()) {
            Item key = entry.getKey();
            Integer value = entry.getValue();
            sum = sum + key.itemPrice * value;
            System.out.println(key.itemName + " цена " + key.itemPrice + " в количестве " + value);

        }
        System.out.println("Общая сумма: " + sum);
    }

    public void recommend() {
        Optional<Map.Entry<Item, Integer>> maxEntry = cart.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()
                );
        System.out.println("**********************************\n" +
                "При следующем вашем визите обратите внимание на эти товары:");
        priceList.showGroupValues(maxEntry.get().getKey().itemGroup);
    }

    public void chengeItemCount(Item item, int count) {
        cart.replace(item, count);
    }
}
