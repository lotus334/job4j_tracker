package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingle3Test {

    @Test
    public void twoCallsOneInstance() {
        Tracker tracker = TrackerSingle3.getInstance();
        Tracker trackerDubbing = TrackerSingle3.getInstance();
        assertThat(tracker, is(trackerDubbing));
    }
}