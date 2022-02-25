package ru.korolkovrs;

public class Task {
    public static Integer calculateSum(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        Integer extractValue = Integer.valueOf(input);
        Integer sum = 0;

        for (int i = 0; i < input.length(); i++) {
            Integer rem = extractValue % 10;
            extractValue /= 10;
            sum += rem;
        }
        return sum;
    }
}
