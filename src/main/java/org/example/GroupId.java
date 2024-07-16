package org.example;

import java.util.HashMap;
import java.util.Map;

public class GroupId extends HashMap<Integer, String> {
    private static GroupId groupId;
    Integer id;
    String title;

    public static GroupId newGroupList() {
        if (groupId == null) {
            groupId = new GroupId();
        }
        return groupId;

    }

    public void addGroup(Integer id, String title) {
        groupId.put(id, title);
    }

    String printGI(Integer id) {
        return id + " " + groupId.get(id);
    }

    //DRY вынес методы печати списков в отдельные методы
    public void showGroupList() {
        for (Map.Entry<Integer, String> entry : groupId.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " " + value);

        }
    }


}


