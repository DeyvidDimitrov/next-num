package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

public class MainTest {
    @Test
    public void test_NextNum1() {

        int[] randomNums = {-1, 0, 1, 2, 3};
        float[] probabilities = {0.01f, 0.3f, 0.58f, 0.09f, 0.02f};
        Map<Integer, Integer> result = Main.getNextNumber(randomNums, probabilities);
        Assertions.assertEquals(Collections.max(result.values()), result.get(1));
        Assertions.assertEquals(Collections.min(result.values()), result.get(-1));
    }
    @Test
    public void test_NextNum2() {

        int[] randomNums = {-1, 0, 1, 2, 3};
        float[] probabilities = {0.25f, 0.2f, 0.11f, 0.09f, 0.35f};
        Map<Integer, Integer> result = Main.getNextNumber(randomNums, probabilities);
        Assertions.assertEquals(Collections.max(result.values()), result.get(3));
        Assertions.assertEquals(Collections.min(result.values()), result.get(2));
    }
}
