package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PriceList priceList = PriceList.newPriceList();
        UserList userList = UserList.newUserList();
        OrderList orderList = OrderList.newOrderList();
        GroupId groupId = GroupId.newGroupList();
        //Magics изначально три группы товаров были реализованы без мапы и существовали в виде текста :) и лишь у товаров было свойство с ИД группы
        groupId.addGroup(1, "Продукты");
        groupId.addGroup(2, "Бытовая химия");
        groupId.addGroup(3, "Спорттовары");
        new Item(1, 100, "Молоко");
        new Item(1, 105, "Хлеб");
        new Item(1, 200, "Яйца");
        new Item(2, 200, "Мыло");
        new Item(2, 500, "Стиральный порошок");
        new Item(2, 150, "Зубная паста");
        new Item(3, 500, "Мяч");
        new Item(3, 5000, "Велосипед");
        new Item(3, 10000, "Самокат");


        User.userGreeting();
        userList.showUserList();
        Cart cart = new Cart();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберете раздел для покупок либо введите 99 чтобы посмотреть весь список товаров:");
            groupId.showGroupList();
            int menuKey;
            while (true) {
                menuKey = scanner.nextInt();
                if (menuKey == 99) {
                    priceList.showPriceList();
                    break;
                } else if (menuKey <= 3) {
                    priceList.showGroupValues(menuKey);
                    break;

                } else if (menuKey == 300) {
                    Item.showTractor();
                } else System.out.println("Выбран неверный номер раздела");
            }
            System.out.print("Выберете товар для покупки либо 99 чтобы вернyться к меню:");
            menuKey = scanner.nextInt();
            if (priceList.containsKey(menuKey)) {
                System.out.print("Введите количество товара:");
                int count = scanner.nextInt();
                cart.addToCart(priceList.getItem(menuKey), count);
                System.out.println("Успешно добавлен в корзину " + priceList.getItem(menuKey) + " в количестве " + count + " штук");
            } else if (menuKey != 99 & !priceList.containsKey(menuKey)) {
                System.out.println("Товара с таким кодом нет!");
            }

            System.out.println("""
                    *********************
                    Введите:
                    1 для завершения покупок и оформления заказа
                    2 чтобы просмотреть корзину
                    0 чтобы продолжить покупки""");
            menuKey = scanner.nextInt();
            if (menuKey == 1) {
                cart.recommend();
                break;
            } else if (menuKey == 2) {
                cart.showCart();
            }


        }

        orderList.newOrder(cart);
    }
}