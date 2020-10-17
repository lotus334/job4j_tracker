package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = 7;
            String choose = scanner.nextLine();
            while (!choose.matches("[0-6]")) {
                choose = scanner.nextLine();
            }
            select = Integer.parseInt(choose);
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Showing all items ====");
                Item[] allItems = tracker.findAll();
                if (allItems.length == 0) {
                    System.out.println("Заявок нет");
                } else {
                    for (Item item : allItems) {
                        System.out.println(item);
                    }
                }
            } else if (select == 2) {
                System.out.println("=== Editing item ====");
                System.out.println("Введите ID заявки, которую необходимо изменить: ");
                int idForDelete = scanner.nextInt();
                System.out.println("Введите ID заявки, на которую необходимо заменить: ");
                int idForRemove = scanner.nextInt();
                if (tracker.findById(idForDelete) == null | tracker.findById(idForRemove) == null) {
                    System.out.println("Ошибка при перемещении заявки");
                } else {
                    Item itemForRemove = new Item(tracker.findById(idForRemove).getName());
                    boolean isRemoved = tracker.replace(idForDelete, itemForRemove);
                    System.out.println(isRemoved ? "Заявка успешно перемещена" : "Ошибка при перемещении заявки");
                }
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
                Item found = tracker.findById(idForSearch);
                System.out.println(found == null ? "Заявка с таким id не найдена" : found);
            } else if (select == 5) {
                System.out.println("=== Finding item by name ====");
                System.out.println("Введите имя заявки, которую необходимо найти: ");
                String nameForSearch = scanner.nextLine();
                Item[] foundItems = tracker.findByName(nameForSearch);
                if (foundItems.length == 0) {
                    System.out.println("Заявки с таким именем не найдены");
                } else {
                    for (Item item : foundItems) {
                        System.out.println(item);
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
