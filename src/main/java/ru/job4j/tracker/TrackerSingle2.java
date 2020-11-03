package ru.job4j.tracker;

public class TrackerSingle2 {
    private static Tracker tracker = new Tracker();

    private TrackerSingle2() { }

    public static Tracker getInstance() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingle2.tracker;
        System.out.println(tracker);
        Tracker tracker1 = TrackerSingle2.getInstance();
        System.out.println(tracker1);
        Tracker tracker2 = TrackerSingle2.getInstance();
        System.out.println(tracker2);

        tracker1.add(new Item("NEW"));
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
    }
}