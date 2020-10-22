package ru.job4j.tracker;

import java.util.Arrays;

public enum TrackerSingle1 {
    INSTANCE;
    private Tracker tracker = new Tracker();

    public static Tracker getInstance() {
        return INSTANCE.tracker;
    }

    public static void main(String[] args) {
        Tracker tr1 = TrackerSingle1.getInstance();
        Tracker tr2 = TrackerSingle1.getInstance();
        tr1.add(new Item("New"));
        System.out.println(Arrays.toString(tr1.findAll()));
        System.out.println(Arrays.toString(tr2.findAll()));
        System.out.println(tr1.findAll());
        System.out.println(tr2.findAll());
    }
}