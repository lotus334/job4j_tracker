package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAscending() {
        Comparator<Job> cmpNameAsc = new JobAscByName();
        int result = cmpNameAsc.compare(
                new Job("Z task", 0),
                new Job("A task", 9)
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameDescending() {
        Comparator<Job> cmpNameAsc = new JobDescByName();
        int result = cmpNameAsc.compare(
                new Job("Z task", 0),
                new Job("A task", 9)
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityAscending() {
        Comparator<Job> cmpNameAsc = new JobAscByPriority();
        int result = cmpNameAsc.compare(
                new Job("A task", 2),
                new Job("Z task", 0)
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriorityDescending() {
        Comparator<Job> cmpNameAsc = new JobDescByPriority();
        int result = cmpNameAsc.compare(
                new Job("A task", 2),
                new Job("Z task", 0)
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityAscending() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByPriorityAndName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByPriorityAndNameAscending() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 2)
        );
        assertThat(rsl, lessThan(0));
    }
}