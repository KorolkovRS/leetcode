package ru.korolkovrs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {

    @ParameterizedTest
    @MethodSource("argsFactory")
    void findTwoTest(TestData testData) {
        int[] answer = Task.findTwo(testData.nums, testData.targetSum);

        assertArrayEquals(answer, testData.targetAnswer);
    }

    static Stream<TestData> argsFactory() {
        return Stream.of(
                new TestData(new int[]{3,15,2,6,7}, 10, new int[]{3, 7}),
                new TestData(new int[]{1,15,2,6,3,7}, 10, new int[]{3, 7}),
                new TestData(new int[]{1,15,3,7,1,2}, 10, new int[]{3, 7}),
                new TestData(new int[]{3,15,2,6,7}, 100, new int[]{}),
                new TestData(new int[]{1}, 1, new int[]{}),
                new TestData(null, 23, new int[]{}),
                new TestData(new int[]{4, 6, 10}, 8, new int[]{})
        );
    }

    static class TestData {
        public TestData(int[] nums, int targetSum, int[] targetAnswer) {
            this.nums = nums;
            this.targetSum = targetSum;
            this.targetAnswer = targetAnswer;
        }

        int[] nums;
        int targetSum;
        int[] targetAnswer;
    }
}