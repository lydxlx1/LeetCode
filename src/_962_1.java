import java.util.AbstractMap;
import java.util.Map;

/**
 * LeetCode 962 - Maximum Width Ramp
 *
 * Divide-and-Conquer approach
 */
public class _962_1 {

    int inf = 1 << 29;

    public int maxWidthRamp(int[] A) {
        Map.Entry<Integer, Integer>[] entries = new Map.Entry[A.length];
        for (int i = 0; i < A.length; i++) {
            entries[i] = new AbstractMap.SimpleEntry(A[i], i);
        }
        int ans = dfs(entries, new Map.Entry[A.length], 0, A.length - 1);
        return ans;
    }

    int dfs(Map.Entry<Integer, Integer>[] entries, Map.Entry<Integer, Integer>[] tmp, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int ans = 0, mid = (left + right) / 2;
        ans = Math.max(ans, dfs(entries, tmp, left, mid));
        ans = Math.max(ans, dfs(entries, tmp, mid + 1, right));

        int smallestIdx = inf;
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (entries[i].getKey() <= entries[j].getKey()) {
                smallestIdx = Math.min(smallestIdx, entries[i].getValue());
                ans = Math.max(ans, entries[j].getValue() - smallestIdx);
                tmp[k++] = entries[i++];
            } else {
                ans = Math.max(ans, entries[j].getValue() - smallestIdx);
                tmp[k++] = entries[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = entries[i++];
        }
        while (j <= right) {
            ans = Math.max(ans, entries[j].getValue() - smallestIdx);
            tmp[k++] = entries[j++];
        }
        System.arraycopy(tmp, left, entries, left, right - left + 1);
        return ans;
    }
}

