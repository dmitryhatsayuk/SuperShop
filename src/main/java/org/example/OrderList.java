package org.example;

import java.util.HashMap;

public class OrderList extends HashMap<Integer, Order> {
    private static OrderList orderList;

    public static OrderList newOrderList() {
        if (orderList == null) {
            orderList = new OrderList();
        }
        return orderList;

    }

    public void newOrder(Cart cart) {
        OrderList orderList = OrderList.newOrderList();
        Order order = new Order(cart);
        orderList.put(order.orderId, order);
        System.out.println("******************************************\n" +
                "Создан заказ№:" + order.orderId + "\n" + "Дата:" + order.orderDate);
        cart.showCart();
        System.out.println("Трек номер для отслеживания:" + order.trackNumber);
    }


}
