package ru.job4j.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(prof -> prof.getAddress())
                .sorted((adr1, adr2) -> adr1.getStreet().compareTo(adr2.getStreet())).distinct()
                .collect(Collectors.toList());
    }
}
