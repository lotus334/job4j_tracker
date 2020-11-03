package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"2", "0"}
                );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit Program ====%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. === Exit Program ====%n"
                )
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new ShowAllAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Showing all items ====" + System.lineSeparator()
                        + "1. === Exit Program ====" + System.lineSeparator()
                        + "Заявок нет" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Showing all items ====" + System.lineSeparator()
                        + "1. === Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("New item");
        tracker.add(item);
        List<UserAction> actions = Arrays.asList(
                new FindByIdAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Finding item by ID ====" + System.lineSeparator()
                        + "1. === Exit Program ====" + System.lineSeparator()
                        + tracker.findById(1) + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Finding item by ID ====" + System.lineSeparator()
                        + "1. === Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "New item", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("New item");
        tracker.add(item);
        List<UserAction> actions = Arrays.asList(
                new FindByNameAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Finding item by name ====" + System.lineSeparator()
                        + "1. === Exit Program ====" + System.lineSeparator()
                        + tracker.findByName("New item").get(0) + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Finding item by name ====" + System.lineSeparator()
                        + "1. === Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
                );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "1", "Replaced item", "2"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(out),
                new ReplaceAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Replaced item"));
    }

    @Test
    public void whenReplaceItemAgain() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", "1", replacedName, "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new ReplaceAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new DeleteAction(out),
                new Exit()
        );
        new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }
}