package ru.job4j.tracker;

public class FindByNameAction implements UserAction{

    @Override
    public String name() {
        return "=== Finding item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String nameForSearch = input.askStr("Введите имя заявки, которую необходимо найти: ");
        Item[] foundItems = tracker.findByName(nameForSearch);
        if (foundItems.length == 0) {
            System.out.println("Заявки с таким именем не найдены");
        } else {
            for (Item oneItem : foundItems) {
                System.out.println(oneItem);
            }
        }
        return true;
    }
}
