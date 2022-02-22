import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;

public class Task1 {
    public static OptionalInt findFirstDuplicate(int[] numbers) {
        Set<Integer> set = new HashSet<>(numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            if (set.contains(numbers[i])) {
                return OptionalInt.of(numbers[i]);
            }
            set.add(numbers[i]);
        }
        return OptionalInt.empty();
    }
}
