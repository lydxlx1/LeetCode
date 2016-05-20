import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode 349 - Intersection of Two Arrays
 *
 * Easy problem...
 */
public class _349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = IntStream.of(nums1).boxed().collect(Collectors.toSet());
        return IntStream.of(nums2).filter(u -> set.contains(u)).distinct().toArray();
    }
}