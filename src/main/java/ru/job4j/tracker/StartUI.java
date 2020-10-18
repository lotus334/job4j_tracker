package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        int select;
        while (run) {
            this.showMenu();
            select = input.askInt("select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String newName = input.askStr("Enter name: ");
                Item newItem = new Item(newName);
                tracker.add(newItem);
            } else if (select == 1) {
                System.out.println("=== Showing all items ====");
                Item[] allItems = tracker.findAll();
                if (allItems.length == 0) {
                    System.out.println("Заявок нет");
                } else {
                    for (Item oneItem : allItems) {
                        System.out.println(oneItem);
                    }
                }
            } else if (select == 2) {
                System.out.println("=== Editing item ====");
                int idForEdit = input.askInt("Введите ID заявки, которую необходимо изменить: ");
                String nameForEdit = input.askStr("Введите имя новой заявки: ");
                Item itemForEdit = new Item();
                itemForEdit.setName(nameForEdit);
                boolean isReplaced = tracker.replace(idForEdit, itemForEdit);
                System.out.println(isReplaced ? "Заявка успешно изменена" : "Ошибка при изменении заявки");
            } else if (select == 3) {
                System.out.println("=== Deleting item ====");
                int idForDelete = input.askInt("Введите ID заявки, которую необходимо удалить: ");
                boolean isDeleted = tracker.delete(idForDelete);
                System.out.println(isDeleted ? "Заявка успешно удалена" : "Ошибка при удалении заявки");
            } else if (select == 4) {
                System.out.println("=== Finding item by ID ====");
                int idForSearch = input.askInt("Введите ID заявки, которую необходимо найти: ");
                Item itemFound = tracker.findById(idForSearch);
                System.out.println(itemFound == null ? "Заявка с таким id не найдена" : itemFound);
            } else if (select == 5) {
                System.out.println("=== Finding item by name ====");
                String nameForSearch = input.askStr("Введите имя заявки, которую необходимо найти: ");
                Item[] foundItems = tracker.findByName(nameForSearch);
                if (foundItems.length == 0) {
                    System.out.println("Заявки с таким именем не найдены");
                } else {
                    for (Item oneItem : foundItems) {
                        System.out.println(oneItem);
                    }
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program\n");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
