package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private List<Item> items = new ArrayList<>(); //Remove
    private int ids = 1;

    public Item add(Item item) {   //Remove
        item.setId(ids++);
        items.add(item);   //Remove
        return item;
    }

    public List<Item> findAll() {     //Remove
        return List.copyOf(items);    //Remove
    }

    public List<Item> findByName(String key) {    //Remove
        List<Item> itemsWithName = new ArrayList<>();
        for (Item item : items) {     //Remove
            if (key.equals(item.getName())) {
                itemsWithName.add(item);
            }
        }
        return List.copyOf(itemsWithName);
    }

    public Item findById(int id) {    //Remove
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean isReplaced = index != -1;
        if (isReplaced) {
            item.setId(id);
            items.remove(index);
            items.add(index, item);
        }
        return isReplaced;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean isDeleted = index != -1;
        if (isDeleted) {
            items.remove(index);
        }
        return isDeleted;
    }
}