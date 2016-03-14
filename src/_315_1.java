import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LeetCode 315 - Count of Smaller Numbers After Self
 *
 * O(n log n) Divide-and-Conquer method via a mergesort
 */
public class _315_1 {
    int[] rank, res, tmp, a;

    private void sort(int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            sort(l, mid);
            sort(mid + 1, r);
            int k = l, i = l, j = mid + 1, cnt = 0;
            while (i <= mid || j <= r)
                if (j > r || i <= mid && a[rank[i]] <= a[rank[j]]) {
                    res[rank[i]] += cnt;
                    tmp[k++] = rank[i++];
                } else {
                    cnt++;
                    tmp[k++] = rank[j++];
                }
            for (k = l; k <= r; k++) rank[k] = tmp[k];
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        a = nums;
        rank = new int[nums.length];
        res = new int[nums.length];
        tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) rank[i] = i;
        sort(0, nums.length - 1);
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
}