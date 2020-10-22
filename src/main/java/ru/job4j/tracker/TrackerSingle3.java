package ru.job4j.tracker;

import java.util.Arrays;

public class TrackerSingle3 {
    private static final Tracker TRACKER = new Tracker();

    private TrackerSingle3() {}

    public static Tracker getInstance() {
        return TRACKER;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingle3.getInstance();
        Tracker tracker2 = TrackerSingle3.getInstance();
        tracker.add(new Item("New"));
        for (Item item : tracker2.findAll()) {
            System.out.println(item);
        }
    }
}