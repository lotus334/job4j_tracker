package ru.job4j.tracker;

public class FindByIdAction implements UserAction{
    @Override
    public String name() {
        return "=== Finding item by ID ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idForSearch = input.askInt("Введите ID заявки, которую необходимо найти: ");
        Item itemFound = tracker.findById(idForSearch);
        System.out.println(itemFound == null ? "Заявка с таким id не найдена" : itemFound);
        return true;
    }
}
