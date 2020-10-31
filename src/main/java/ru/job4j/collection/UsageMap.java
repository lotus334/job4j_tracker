package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> newMap = new HashMap<>();
        newMap.put("lotus33497@yandex.ru", "Vasilyev Dmitriy Alexandrovich");
        for (String key :newMap.keySet()) {
            String value = newMap.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
