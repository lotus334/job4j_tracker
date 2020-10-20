package ru.job4j.tracker;

public class ReplaceAction implements UserAction{

    @Override
    public String name() {
        return "=== Editing item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idForEdit = input.askInt("Введите ID заявки, которую необходимо изменить: ");
        String nameForEdit = input.askStr("Введите имя новой заявки: ");
        Item itemForEdit = new Item();
        itemForEdit.setName(nameForEdit);
        boolean isReplaced = tracker.replace(idForEdit, itemForEdit);
        System.out.println(isReplaced ? "Заявка успешно изменена" : "Ошибка при изменении заявки");
        return true;
    }
}
