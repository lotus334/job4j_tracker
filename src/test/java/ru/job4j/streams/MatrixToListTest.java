package ru.job4j.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest {
    @Test
    public void matrixToList() {
        MatrixToList matrixToList = new MatrixToList();
        Integer[][] matrix = new Integer[][]{{1, 2, 3}, {4, 5, 6}};
        List<Integer> result = matrixToList.collect(matrix);
        List<Integer> expected = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        assertThat(result, is(expected));
    }
}