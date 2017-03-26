import java.util.stream.Stream;

/**
 * LeetCode 537 - Complex Number Multiplication
 * <p>
 * Brute-force
 */
public class _537 {
    public String complexNumberMultiply(String a, String b) {
        int[] aa = Stream.of(a.split("[+i]")).mapToInt(Integer::parseInt).toArray();
        int[] bb = Stream.of(b.split("[+i]")).mapToInt(Integer::parseInt).toArray();
        return String.format("%d+%di", aa[0] * bb[0] - aa[1] * bb[1], +aa[0] * bb[1] + aa[1] * bb[0]);
    }
}
