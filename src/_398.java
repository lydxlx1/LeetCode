import java.util.Random;

/**
 * LeetCode 398 - Random Pick Index
 * <p>
 * 1. Sort indices [0, n) by the corresponding value.
 * 2. For each pick query, we do two binary searches to find the left and right boundaries and then throw a die to
 * return a random index.
 * <p>
 * O(n log n) build time
 * O(log n) query time
 */
public class _398 {
    Random rand;
    int[] rank;
    int[] nums;

    private void quickSort(int l, int r) {
        int i = l, j = r, x = rank[rand.nextInt(r - l + 1) + l];
        do {
            while (nums[rank[i]] < nums[x]) i++;
            while (nums[rank[j]] > nums[x]) j--;
            if (i <= j) {
                int tmp = rank[i];
                rank[i] = rank[j];
                rank[j] = tmp;
                i++;
                j--;
            }
        }
        while (i <= j);
        if (i < r) quickSort(i, r);
        if (j > l) quickSort(l, j);
    }

    public _398(int[] nums) {
        rand = new Random();
        this.nums = nums;
        rank = new int[nums.length];
        for (int i = 0; i < rank.length; i++) rank[i] = i;
        quickSort(0, rank.length - 1);
    }

    public int pick(int target) {
        int left = -1, right = rank.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[rank[mid]] < target) left = mid;
            else right = mid;
        }
        int begin = right;

        left = 0;
        right = rank.length;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[rank[mid]] > target) right = mid;
            else left = mid;
        }
        int end = left;

        return rank[rand.nextInt(end - begin + 1) + begin];
    }
}