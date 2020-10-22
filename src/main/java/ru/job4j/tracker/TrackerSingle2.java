package ru.job4j.tracker;

import java.util.Arrays;

public class TrackerSingle2 {
    private static TrackerSingle2 instance;
    private static Tracker tracker = new Tracker();

    private TrackerSingle2() {}

    public static TrackerSingle2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle2();
        }
        return instance;
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
        TrackerSingle2 tracker = TrackerSingle2.instance;
        System.out.println(tracker);
        TrackerSingle2 tracker1 = TrackerSingle2.getInstance();
        System.out.println(tracker1);
        TrackerSingle2 tracker2 = TrackerSingle2.getInstance();
        System.out.println(tracker2);

        tracker1.add(new Item("NEW"));
        System.out.println(Arrays.toString(tracker1.findAll()));
        System.out.println(Arrays.toString(tracker2.findAll()));
    }
}