package ru.job4j.collection;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(start + "/" + el);
                start += "/" + el;
            }
        }
        List<String> list = tmp.stream()
                .map(str -> str.replaceFirst("/", ""))
                .collect(Collectors.toList());
        return list;
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        var compDesc = new DepDescComp();
        orgs.sort(compDesc.thenComparing(Comparator.naturalOrder()));
    }
}
