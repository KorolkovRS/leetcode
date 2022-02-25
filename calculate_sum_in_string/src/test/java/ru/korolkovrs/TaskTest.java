package ru.korolkovrs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @ParameterizedTest
    @MethodSource("argsFactory")
    void calculateSumTest(Pair testData) {
        assertEquals(Task.calculateSum(testData.data), testData.expectAnswer);
    }

    @Test
    void shouldThrowExceptionIfDataIsNotValue() {
        assertThrows(Exception.class, () -> Task.calculateSum("123dfdf123"));
    }

    static Stream<Pair> argsFactory() {
        return Stream.of(
                new Pair(null, 0),
                new Pair("", 0),
                new Pair("1", 1),
                new Pair("123", 6)
        );
    }

    static class Pair {
        public Pair(String data, Integer expectAnswer) {
            this.data = data;
            this.expectAnswer = expectAnswer;
        }

        String data;
        Integer expectAnswer;
    }
}