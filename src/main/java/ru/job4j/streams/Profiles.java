package ru.job4j.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(prof -> prof.getAddress()).collect(Collectors.toList());
    }
}
