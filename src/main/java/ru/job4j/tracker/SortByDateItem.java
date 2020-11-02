package ru.job4j.tracker;

import java.util.Comparator;

public class SortByDateItem implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return first.getCreated().compareTo(second.getCreated());
    }
}
