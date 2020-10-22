package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingle4Test {
    @Test
    public void twoCallsOneInstance() {
        Tracker tracker = TrackerSingle4.getInstance();
        Tracker trackerDubbing = TrackerSingle4.getInstance();
        assertThat(tracker, is(trackerDubbing));
    }
}