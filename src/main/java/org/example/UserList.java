package org.example;

import java.util.HashMap;
import java.util.Map;

public class UserList extends HashMap<Integer,User> {
    static int userCounter;
    private static UserList userList;
    public static UserList newUserList() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;

    }

    public void addUser(User user) {
        userList.put(setUserId(),user);
    }

    public void showUserList() {
        for (Map.Entry<Integer, User> entry : userList.entrySet()) {
            Integer key = entry.getKey();
            User value = entry.getValue();
            System.out.println("Пользователь ID " +key + " email " + value);
        }
    }

    public int setUserId() {
        return userCounter++;
    }

}
