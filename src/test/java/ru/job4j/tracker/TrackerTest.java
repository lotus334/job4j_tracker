package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenHasNullItemsThenFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        tracker.add(item1);
        Item item2 = new Item();
        tracker.add(item2);
        Item[] out = tracker.findAll();
        Item[] expected = {item1, item2};
        assertThat(out, is(expected));
    }

    @Test
    public void whenHas2IvanItemThenFindByName() {
        Tracker tracker = new Tracker();
        Item petya = new Item();
        petya.setName("Petya");
        tracker.add(petya);
        Item ivan = new Item();
        ivan.setName("Ivan");
        tracker.add(ivan);
        Item vanya = new Item();
        tracker.add(vanya);
        vanya.setName("Ivan");
        Item[] out = tracker.findByName("Ivan");
        Item[] expected = {ivan, vanya};
        assertThat(out, is(expected));
    }

    @Test
    public void whenHadIdThenFindById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        tracker.add(item1);
        Item item2 = new Item();
        tracker.add(item2);
        Item item3 = new Item();
        tracker.add(item3);
        Item out = tracker.findById(2);
        Item expected = item2;
        assertThat(out, is(expected));
    }
}