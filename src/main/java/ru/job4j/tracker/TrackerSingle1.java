package ru.job4j.tracker;

import java.util.Arrays;

public enum TrackerSingle1 {
    INSTANCE;
    Tracker tracker;

    TrackerSingle1() {
        tracker = new Tracker();
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public static void main(String[] args) {
        TrackerSingle1 tracker = TrackerSingle1.INSTANCE;
        Tracker tr1 = tracker.tracker;
        Tracker tr2 = tracker.tracker;
        tr1.add(new Item("New"));
        System.out.println(Arrays.toString(tr1.findAll()));
        System.out.println(Arrays.toString(tr2.findAll()));
    }
}