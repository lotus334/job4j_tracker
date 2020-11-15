package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> {
            System.out.println();
            return left.getSize() - right.getSize();
        };

        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left + " : " + right);
            return Integer.compare(right.length(), left.length());
        };

        String[] array = {"short", "longer"};
        Arrays.sort(array, cmpDescSize);
        System.out.println(Arrays.toString(array));

        Arrays.sort(atts, comparator);
    }
}
