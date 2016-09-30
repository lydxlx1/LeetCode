import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 47 - Permutation II
 *
 * Implement next_permutation function
 */
public class _47 {
    int[] nums, tmp, cnt;

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void reverse(int[] a, int i, int j) {
        for (; i < j; i++, j--) swap(a, i, j);
    }

    private boolean nextPermutation(int[] a) {
        for (int i = a.length - 2; i >= 0; i--)
            if (a[i] < a[i + 1]) {
                for (int j = a.length - 1; j > i; j--)
                    if (a[i] < a[j]) {
                        swap(a, i, j);
                        reverse(a, i + 1, a.length - 1);
                        return true;
                    }
            }

        return false;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        do {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int num : nums) list.add(num);
            ans.add(list);
        } while (nextPermutation(nums));
        return ans;
    }
}