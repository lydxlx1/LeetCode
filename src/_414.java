import java.util.Optional;

/**
 * LeetCode 414 - Third Maximum Number
 *
 * One-pass solution
 */
public class _414 {
    public int thirdMax(int[] nums) {
        Optional<Integer> first = Optional.empty();
        Optional<Integer> second = Optional.empty();
        Optional<Integer> third = Optional.empty();
        for (int i : nums) {
            if (!first.isPresent() || i > first.get()) {
                third = second;
                second = first;
                first = Optional.of(i);
            } else if (first.isPresent() && i < first.get() && (!second.isPresent() || i > second.get())) {
                third = second;
                second = Optional.of(i);
            } else if (second.isPresent() && i < second.get() && (!third.isPresent() || i > third.get())) {
                third = Optional.of(i);
            }
        }
        return third.isPresent() ? third.get() : first.get();
    }
}