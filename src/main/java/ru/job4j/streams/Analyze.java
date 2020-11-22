package ru.job4j.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .map(Pupil::getSubjects)
                .flatMap(list -> list.stream().map(Subject::getScore))
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.getName(), pupil
                        .getSubjects()
                        .stream()
                        .map(subject -> subject.getScore())
                        .mapToDouble(Integer::doubleValue)
                        .average()
                        .orElse(0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::getName, Collectors
                                .averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.getName(), pupil
                        .getSubjects()
                        .stream()
                        .map(Subject::getScore)
                        .mapToDouble(Integer::doubleValue)
                        .sum()))
                .max((o1, o2) -> Double.compare(o1.getScore(), o2.getScore()))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(Subject::getName, Collectors
                                .summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max((o1, o2) -> Double.compare(o1.getScore(), o2.getScore()))
                .orElse(null);
    }
}
