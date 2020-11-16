package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FITest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionCalc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FunctionCalc.diapason(2, 5, x -> x * x + 2 * x + 1);
        List<Double> expected = Arrays.asList(9D, 16D, 25D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPowFunctionThenPowResults() {
        List<Double> result = FunctionCalc.diapason(0, 3, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(1D, 3D, 9D);
        assertThat(result, is(expected));
    }
}