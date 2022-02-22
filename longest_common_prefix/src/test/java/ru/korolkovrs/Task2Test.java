package ru.korolkovrs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @ParameterizedTest
    @MethodSource("argsFactory")
    void longestCommonPrefixTest(Pair testData) {
        System.out.println(testData);
        String longestPrefix = Task2.longestCommonPrefix(testData.strings);

        assertEquals(longestPrefix, testData.exceptedString);
    }

    static Stream<Pair> argsFactory() {
        return Stream.of(
                new Pair(new String[]{"fl","fl","fl","fl"}, "fl"),
                new Pair(new String[]{"flower", "flow", "flight"}, "fl"),
                new Pair(new String[]{"dog","racecar","car"}, ""),
                new Pair(new String[]{"", "hello", "hex"}, ""),
                new Pair(new String[]{}, "")
        );
    }

    static class Pair {
        public Pair(String[] strings, String exceptedString) {
            this.strings = strings;
            this.exceptedString = exceptedString;
        }

        String[] strings;
        String exceptedString;
    }
}