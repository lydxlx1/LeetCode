import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode 350 - Intersection of Two Arrays II
 *
 * Merge-sort based approach
 */
public class _350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] nums1Sorted = IntStream.of(nums1).sorted().toArray();
        int[] nums2Sorted = IntStream.of(nums2).sorted().toArray();
        List<Integer> res = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1Sorted.length && j < nums2Sorted.length; )
            if (nums1Sorted[i] < nums2Sorted[j]) i++;
            else if (nums1Sorted[i] > nums2Sorted[j]) j++;
            else {
                res.add(nums2Sorted[j]);
                i++;
                j++;
            }
        return res.stream().mapToInt(u -> u).toArray();
    }
}