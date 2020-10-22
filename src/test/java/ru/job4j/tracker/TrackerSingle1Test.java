package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSingle1Test {
    @Test
    public void twoCallsOneInstance() {
        TrackerSingle1 tracker = TrackerSingle1.INSTANCE;
        TrackerSingle1 trackerDubbing = TrackerSingle1.INSTANCE;
        assertThat(tracker, is(trackerDubbing));
    }
}