package ru.job4j.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    private List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
        profiles.add(new Profile(new Address("City1", "Street2", 1, 2)));
        profiles.add(new Profile(new Address("City5", "Street6", 5, 6)));
        profiles.add(new Profile(new Address("City3", "Street4", 3, 4)));
        profiles.add(new Profile(new Address("City1", "Street2", 1, 2)));
        profiles.add(new Profile(new Address("City3", "Street4", 3, 4)));
    }

    @Test
    public void whenCollectAddresses() {
        List<Address> result = new Profiles().collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("City1", "Street2", 1, 2));
        expected.add(new Address("City3", "Street4", 3, 4));
        expected.add(new Address("City5", "Street6", 5, 6));
        assertThat(result, is(expected));
    }
}