package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        int select;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            select = scanner.nextInt();
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String newName = scanner.next();
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
                System.out.println("Введите ID заявки, которую необходимо изменить: ");
                int idForEdit = scanner.nextInt();
                System.out.println("Введите имя новой заявки: ");
                String nameForEdit = scanner.next();
                Item itemForEdit = new Item();
                itemForEdit.setName(nameForEdit);
                boolean isReplaced = tracker.replace(idForEdit, itemForEdit);
                System.out.println(isReplaced ? "Заявка успешно изменена" : "Ошибка при изменении заявки");
            } else if (select == 3) {
                System.out.println("=== Deleting item ====");
                System.out.println("Введите ID заявки, которую необходимо удалить: ");
                int idForDelete = scanner.nextInt();
                boolean isDeleted = tracker.delete(idForDelete);
                System.out.println(isDeleted ? "Заявка успешно удалена" : "Ошибка при удалении заявки");
            } else if (select == 4) {
                System.out.println("=== Finding item by ID ====");
                System.out.println("Введите ID заявки, которую необходимо найти: ");
                int idForSearch = scanner.nextInt();
                Item itemFound = tracker.findById(idForSearch);
                System.out.println(itemFound == null ? "Заявка с таким id не найдена" : itemFound);
            } else if (select == 5) {
                System.out.println("=== Finding item by name ====");
                System.out.println("Введите имя заявки, которую необходимо найти: ");
                String nameForSearch = scanner.next();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
