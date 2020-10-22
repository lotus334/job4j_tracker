package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingle2Test {

    @Test
    public void twoCallsOneInstance() {
        TrackerSingle2 tracker = TrackerSingle2.getInstance();
        TrackerSingle2 trackerDubbing = TrackerSingle2.getInstance();
        assertThat(tracker, is(trackerDubbing));
    }
}