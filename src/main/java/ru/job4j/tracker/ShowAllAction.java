package ru.job4j.tracker;

public class ShowAllAction implements UserAction{

    @Override
    public String name() {
        return "=== Showing all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll();
        if (allItems.length == 0) {
            System.out.println("Заявок нет");
        } else {
            for (Item oneItem : allItems) {
                System.out.println(oneItem);
            }
        }
        return true;
    }
}
