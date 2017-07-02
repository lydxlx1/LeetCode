import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * LeetCode 632 - Smallest Range
 */
public class _632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums.size() == 1)
            return new int[]{nums.get(0).get(0), nums.get(0).get(0)};

        int[] res = {-111111, 111111};
        TreeSet<int[]> tree = new TreeSet<>(Comparator
                .<int[], Integer>comparing(u -> nums.get(u[0]).get(u[1]))
                .thenComparing(u -> u[0]));
        for (int i = 0; i < nums.size(); i++)
            tree.add(new int[]{i, 0});
        while (tree.size() == nums.size()) {
            // Since the size of nums is >= 2, min != max
            int[] min = tree.pollFirst();
            int[] max = tree.last();

            int begin = nums.get(min[0]).get(min[1]);
            int end = nums.get(max[0]).get(max[1]);
            if (end - begin < res[1] - res[0]) {
                res[0] = begin;
                res[1] = end;
            }

            if (min[1] < nums.get(min[0]).size() - 1) {
                min[1]++;
                tree.add(min);
            }
        }
        return res;
    }
}