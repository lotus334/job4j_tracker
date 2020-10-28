package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction{
    private Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Showing all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> allItems = tracker.findAll();
        if (allItems.size() == 0) {
            out.println("Заявок нет");
        } else {
            for (Item oneItem : allItems) {
                out.println(oneItem);
            }
        }
        return true;
    }
}
