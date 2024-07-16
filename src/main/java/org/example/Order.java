package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private static int orderCount;

    public int orderId;
    public String orderDate;
    public String trackNumber;
    public Cart cart;


    Order(Cart cart) {
        this.orderId = getOrderCount();
        this.orderDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss"));
        this.trackNumber = "630089" + Math.round((Math.random() * 100)) * 2345 + "RUS";
        this.cart = cart;
    }

    private int getOrderCount() {
        return orderCount++;
    }
}