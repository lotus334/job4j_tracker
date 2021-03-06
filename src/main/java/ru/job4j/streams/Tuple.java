package ru.job4j.streams;

import java.util.Objects;

public class Tuple {
    private final String name;
    private final double score;

    public Tuple(String name, double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple) o;
        return Double.compare(tuple.score, score) == 0
                && Objects.equals(name, tuple.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Tuple{"
                + "name='" + name + '\''
                + ", score=" + score
                + '}';
    }
}
