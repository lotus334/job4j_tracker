package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingle4Test {
    @Test
    public void twoCallsOneInstance() {
        TrackerSingle4 tracker = TrackerSingle4.getInstance();
        TrackerSingle4 trackerDubbing = TrackerSingle4.getInstance();
        assertThat(tracker, is(trackerDubbing));
    }
}