package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

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
        List<Item> out = tracker.findAll();
        List<Item> expected = Arrays.asList(item1, item2);
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
        List<Item> out = tracker.findByName("Ivan");
        List<Item> expected = Arrays.asList(ivan, vanya);
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

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        System.out.println(tracker.findAll());
        assertThat(tracker.findById(id), is(nullValue()));
    }
}