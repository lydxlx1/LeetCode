import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode 962 - Maximum Width Ramp
 *
 * Just sort...
 */
public class _962_2 {

    int inf = 1 << 29;

    public int maxWidthRamp(int[] A) {
        int ans = 0;
        int minIndex = inf;
        List<Integer> idx = IntStream.range(0, A.length).boxed()
                .sorted(Comparator.<Integer>comparingInt(i -> A[i]).thenComparing(i -> i))
                .collect(Collectors.toList());
        for (int i : idx) {
            ans = Math.max(ans, i - minIndex);
            minIndex = Math.min(minIndex, i);
        }
        return ans;
    }
}

