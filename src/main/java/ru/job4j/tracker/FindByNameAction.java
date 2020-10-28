package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction{
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Finding item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String nameForSearch = input.askStr("Введите имя заявки, которую необходимо найти: ");
        List<Item> foundItems = tracker.findByName(nameForSearch);
        if (foundItems.size() == 0) {
            out.println("Заявки с таким именем не найдены");
        } else {
            for (Item oneItem : foundItems) {
                out.println(oneItem);
            }
        }
        return true;
    }
}
