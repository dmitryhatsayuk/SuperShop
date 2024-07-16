package org.example;

public class Item {
    int itemId;
    int itemGroup;
    int itemPrice;
    String itemName;
    static int itemCounter;

    Item(int itemGroup, int itemPrice, String itemName) {
        PriceList priceList = PriceList.newPriceList();
        this.itemId = setItemId();
        this.itemGroup = itemGroup;
        this.itemPrice = itemPrice;
        this.itemName = itemName;
        priceList.addItem(this);
    }

    public static void showTractor() {
        System.out.println("""
                ┼ ┼ ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓
                ┼ ┼ ┼ ▓ ░ ░ ▓ ░ ░ ▓ ┼ ┼ ┼ ▒
                ┼ ┼ ┼ ▓ ░ ░ ▓ ░ ░ ▓ ┼ ┼ ┼ ▒
                ┼ ┼ ┼ ▓ ░ ░ ▓ ░ ░ ▓ ▓ ┼ ┼ ▒
                ┼ ┼ ┼ ▓ ░ ░ ▓ ░ ░ ░ ▓ ┼ ┼ ▒
                ┼ ┼ ┼ ▓ ░ ░ ▓ ░ ░ ░ ▓ ┼ ┼ ▒
                ┼ ┼ ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓
                ┼ ▓ ▓ █ █ █ ▓ ▓ ▒ ▒ ▓ █ █ █ █ ▓ ▓
                ┼ ┼ █ █ █ █ █ ▓ ▓ ▒ ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓
                ┼ █ █ █ ▒ █ █ █ ▓ ▒ ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓
                ┼ █ █ ▒ ▒ ▒ █ █ ▓ ▓ ▓ ▓ ▓ ▓ █ █ ▓ ▓
                ┼ █ █ █ ▒ █ █ █ ┼ ┼ ┼ ┼ ┼ █ ▒ ▒ █
                ┼ ┼ █ █ █ █ █ ┼ ┼ ┼ ┼ ┼ ┼ █ ▒ ▒ █
                ┼ ┼ ┼ █ █ █ ┼ ┼ ┼ ┼ ┼ ┼ ┼ ┼ █ █
                I'm coming!!!!""");
    }

    int setItemId() {
        return itemCounter++;

    }

    @Override
    public String toString() {
        return itemName + " по цене " + itemPrice;
    }
}


