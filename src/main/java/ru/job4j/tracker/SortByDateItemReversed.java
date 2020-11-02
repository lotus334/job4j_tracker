package ru.job4j.tracker;

import java.util.Comparator;

public class SortByDateItemReversed implements Comparator<Item> {
    public int compare(Item o1, Item o2) {
        return o2.created.compareTo(o1.created);
    }
}
