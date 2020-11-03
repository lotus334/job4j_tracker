package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest {

    @Test
    public void compareToAscendingOrderById() {
        Item item1 = new Item(1, "first");
        Item item3 = new Item(3, "third");
        Item item2 = new Item(2, "second");
        List<Item> list = Arrays.asList(
                item1,
                item3,
                item2
        );
        Collections.sort(list, new SortByIdItem());
        List<Item> expected = Arrays.asList(item1, item2, item3);
        assertThat(list, is(expected));
    }

    @Test
    public void compareToReverseOrderById() {
        Item item1 = new Item(1, "first");
        Item item3 = new Item(3, "third");
        Item item2 = new Item(2, "second");
        List<Item> list = Arrays.asList(
                item1,
                item3,
                item2
        );
        Collections.sort(list, new SortByIdItemReversed());
        List<Item> expected = Arrays.asList(item3, item2, item1);
        assertThat(list, is(expected));
    }

    @Test
    public void compareToAscendingOrderByName() {
        Item item1 = new Item(3, "first");
        Item item3 = new Item(1, "third");
        Item item2 = new Item(2, "second");
        List<Item> list = Arrays.asList(
                item1,
                item3,
                item2
        );
        Collections.sort(list, new SortByNameItem());
        List<Item> expected = Arrays.asList(item1, item2, item3);
        assertThat(list, is(expected));
    }

    @Test
    public void compareToReverseOrderByName() {
        Item item1 = new Item(3, "first");
        Item item3 = new Item(1, "third");
        Item item2 = new Item(2, "second");
        List<Item> list = Arrays.asList(
                item1,
                item3,
                item2
        );
        Collections.sort(list, new SortByNameItemReversed());
        List<Item> expected = Arrays.asList(item3, item2, item1);
        assertThat(list, is(expected));
    }
}