package ru.job4j.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sandbox {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 34, -56, -789, 1012));
        arrayList.stream().filter(num -> num > 0).collect(Collectors.toList());
    }
}
