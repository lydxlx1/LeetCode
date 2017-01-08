import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * LeetCode 480 - Sliding Window Median
 * <p>
 * An easy implementation of Order-Statistic Tree using Fenwick Tree
 * O(log^2 n) per operation
 */
public class _480 {
    static class OrderStatisticTree {
        private final int[] bit;
        private final int universeSize;

        /**
         * Numbers are within the range [0, universeSize)
         * However, the internal Binary Indexed Tree maintains values ranging from [1, universeSize].
         */
        public OrderStatisticTree(int universeSize) {
            this.universeSize = universeSize;
            bit = new int[universeSize + 1];
        }

        private void add(int index, int value) {
            for (; index < bit.length; index += Integer.lowestOneBit(index))
                bit[index] += value;
        }

        private int prefixSum(int index) {
            int sum = 0;
            for (; index > 0; index -= Integer.lowestOneBit(index))
                sum += bit[index];
            return sum;
        }

        public void insert(int num) {
            add(num + 1, 1);
        }

        public void remove(int num) {
            add(num + 1, -1);
        }

        /**
         * @return the number within [0, universeSize) that has the given rank.
         */
        public int retriveByRank(int rank) {
            int left = -1, right = universeSize - 1;
            while (left + 1 < right) {
                int mid = (left + right) / 2;
                if (prefixSum(mid + 1) >= rank) right = mid;
                else left = mid;
            }
            return right;
        }

        @Override
        public String toString() {
            StringJoiner joiner = new StringJoiner(", ", "[", "]");
            int maxRank = prefixSum(bit.length - 1);
            for (int i = 1; i <= maxRank; i++) joiner.add("" + retriveByRank(i));
            return joiner.toString();
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int[] keys = IntStream.of(nums).distinct().sorted().toArray();
        OrderStatisticTree osTree = new OrderStatisticTree(keys.length);
        for (int i = 0; i < nums.length; i++)
            nums[i] = Arrays.binarySearch(keys, nums[i]);

        double[] medians = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            osTree.insert(nums[i]);
            if (i - k >= 0) osTree.remove(nums[i - k]);
            if (i >= k - 1) {
                double median = 0;
                if (k % 2 == 0) {
                    median += keys[osTree.retriveByRank(k / 2)];
                    median += keys[osTree.retriveByRank(k / 2 + 1)];
                    median /= 2;
                } else {
                    median += keys[osTree.retriveByRank(k / 2 + 1)];
                }
                medians[i - k + 1] = median;
            }
        }
        return medians;
    }
}