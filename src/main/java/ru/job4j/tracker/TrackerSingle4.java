package ru.job4j.tracker;

public class TrackerSingle4 {
    private TrackerSingle4() { }

    public static Tracker getInstance() {
        return Holder.TRACKER;
    }

    private static final class Holder {
        private static final Tracker TRACKER = new Tracker();
    }

    public static void main(String[] args) {
        TrackerSingle4 singleton = new TrackerSingle4();
        System.out.println(singleton);
        Tracker tr1 = TrackerSingle4.getInstance();
        System.out.println(tr1);
        tr1.add(new Item("New"));
        Tracker tr2 = TrackerSingle4.getInstance();
        System.out.println(tr2);

        for (Item item : tr2.findAll()) {
            System.out.println(item);
        }
    }
}