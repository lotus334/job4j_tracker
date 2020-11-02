package ru.job4j.collection;

import java.util.Comparator;

public class SortByNameUser implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return CharSequence.compare(o1.getName(), o2.getName());
    }
}
