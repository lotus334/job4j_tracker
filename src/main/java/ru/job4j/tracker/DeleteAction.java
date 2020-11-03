package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Deleting item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idForDelete = input.askInt("Введите ID заявки, которую необходимо удалить: ");
        boolean isDeleted = tracker.delete(idForDelete);
        out.println(isDeleted ? "Заявка успешно удалена" : "Ошибка при удалении заявки");
        return true;
    }
}
