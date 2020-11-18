package ru.job4j.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public Map<String, Student> collectToMap(List<Student> students) {
        return students.stream()
//                .distinct()
                .collect(Collectors.toMap(
                        key -> key.getSurname(),
                        val -> val,
                        (student1, student2) -> student1
                ));
    }
}
