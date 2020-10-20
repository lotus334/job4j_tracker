package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        int select;
        while (run) {
            this.showMenu(actions);
            select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
        /*
        while (run) {
            this.showMenu();
            select = input.askInt("select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }

         */
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    /*
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Showing all items ====");
        Item[] allItems = tracker.findAll();
        if (allItems.length == 0) {
            System.out.println("Заявок нет");
        } else {
            for (Item oneItem : allItems) {
                System.out.println(oneItem);
            }
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Editing item ====");
        int idForEdit = input.askInt("Введите ID заявки, которую необходимо изменить: ");
        String nameForEdit = input.askStr("Введите имя новой заявки: ");
        Item itemForEdit = new Item();
        itemForEdit.setName(nameForEdit);
        boolean isReplaced = tracker.replace(idForEdit, itemForEdit);
        System.out.println(isReplaced ? "Заявка успешно изменена" : "Ошибка при изменении заявки");
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Deleting item ====");
        int idForDelete = input.askInt("Введите ID заявки, которую необходимо удалить: ");
        boolean isDeleted = tracker.delete(idForDelete);
        System.out.println(isDeleted ? "Заявка успешно удалена" : "Ошибка при удалении заявки");
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Finding item by ID ====");
        int idForSearch = input.askInt("Введите ID заявки, которую необходимо найти: ");
        Item itemFound = tracker.findById(idForSearch);
        System.out.println(itemFound == null ? "Заявка с таким id не найдена" : itemFound);
    }

    public static void findByName(Input input, Tracker tracker) {
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
    }

     */

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAllAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
