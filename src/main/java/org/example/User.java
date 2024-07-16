package org.example;

import java.util.Map;
import java.util.Scanner;

public class User {
    String userMail;
    String userPwd;


    User(String userMail, String userPwd) {

        this.userMail = userMail;
        this.userPwd = userPwd;
    }

    public static void userGreeting() {
        User user;
        UserList userList = UserList.newUserList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в SuperShop");
        System.out.println("Введите ваш e-mail");
        String userMail = scanner.nextLine();
        if (userPresent(userMail)) {
            while (true) {
                if (pwdCheck(userMail)) {
                    for (Map.Entry<Integer, User> entry : userList.entrySet()) {
                        User value = entry.getValue();
                        if (value.userMail.equals(userMail)) {
                            break;
                        }
                    }
                    break;
                }
            }
        } else {
            System.out.println("Такого пользователя еще нет");
            System.out.print("Придумайте пароль:");
            user = new User(userMail, scanner.nextLine());
            userList.addUser(user);
        }
    }


    public static boolean userPresent(String email) {
        UserList userList = UserList.newUserList();
        boolean flag = false;
        for (Map.Entry<Integer, User> entry : userList.entrySet()) {
            User value = entry.getValue();
            if (value.userMail.equals(email)) {
                flag = true;
                break;
            }
        }
        return flag;
    }


    public static boolean pwdCheck(String email) {
        UserList userList = UserList.newUserList();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль:");
        boolean flag = false;
        for (Map.Entry<Integer, User> entry : userList.entrySet()) {
            User value = entry.getValue();
            if (value.userMail.equals(email) && value.userPwd.equals(scanner.nextLine())) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Пароль подтвержден");
        } else {
            System.out.println("Пароль не верный");
        }
        return flag;

    }

    @Override
    public String toString() {
        return userMail;
    }

}


