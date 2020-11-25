package ru.job4j.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private Integer[] array;

    private EasyStream(Integer[] array) {
        this.array = array;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source.toArray(Integer[]::new));
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        for (int i = 0; i < array.length; i++) {
            array[i] = fun.apply(array[i]);
        }
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        Integer[] newArray = new Integer[array.length];
        int counter = 0;
        for (Integer integer : array) {
            if (fun.test(integer)) {
                newArray[counter] = integer;
                counter++;
            }
        }
        Integer[] result = new Integer[counter];
        System.arraycopy(newArray, 0, result, 0, counter);
        this.array = result;
        return this;
    }

    public List<Integer> collect() {
        return Arrays.asList(array);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Elements:");
        for (Integer el : array) {
            stringBuilder
                    .append(System.lineSeparator())
                    .append(el);
        }
        return stringBuilder.toString();
    }
}