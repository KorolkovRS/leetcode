import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.OptionalInt;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {

    @ParameterizedTest
    @MethodSource("argsFactory")
    void findFirstDuplicateTest(Pair testData) {
        OptionalInt result = Task1.findFirstDuplicate(testData.numbers);

        assertEquals(result, testData.expectedOptionalInt);
    }

    static Stream<Pair> argsFactory() {
        return Stream.of(
                new Pair(new int[]{1,2,3,4,1,2,3}, OptionalInt.of(1)),
                new Pair(new int[]{3,4,1,2,2}, OptionalInt.of(2)),
                new Pair(new int[]{5}, OptionalInt.empty()),
                new Pair(new int[]{}, OptionalInt.empty())
        );
    }

    static class Pair {
        public Pair(int[] numbers, OptionalInt expectedNum) {
            this.numbers = numbers;
            this.expectedOptionalInt = expectedNum;
        }

        int[] numbers;
        OptionalInt expectedOptionalInt;
    }
}