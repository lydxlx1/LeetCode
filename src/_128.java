import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode 128 - Longest Consecutive Sequence
 *
 * O(n) - HashSet
 */
public class _128 {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Long> set = IntStream.of(nums).asLongStream().boxed().collect(Collectors.toSet());
        while (!set.isEmpty()) {
            int cnt = 0;
            long current = set.iterator().next();
            for (long i = current; set.contains(i); i++, cnt++) set.remove(i);
            for (long i = current - 1; set.contains(i); i--, cnt++) set.remove(i);
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
