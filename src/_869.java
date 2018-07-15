import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 869 - Reordered Power of 2
 * <p>
 * Dictionary lookup
 */
public class _869 {

    public boolean reorderedPowerOf2(int N) {
        Set<String> candidates = new HashSet<>();
        for (int i = 0; i < 32; i++) {
            char[] s = ("" + (1L << i)).toCharArray();
            Arrays.sort(s);
            candidates.add(String.valueOf(s));
        }
        char[] n = ("" + N).toCharArray();
        Arrays.sort(n);
        return candidates.contains(String.valueOf(n));
    }
}

