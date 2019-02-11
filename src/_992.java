import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 992 - Subarrays with K Different Integers
 *
 * Two Sliding Windows
 */
public class _992 {

    public int subarraysWithKDistinct(int[] A, int K) {
        int ans = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        // Enumerate the left boundary of the subarray and maintain two sliding windows, where for every fixed left boundary i,
        // [i, j) is the minimal window with K different integers, and
        // [i, jj) is the minimal window with K + 1 different integers.
        // If such window does not exist, either j or jj will be equal to A.length.
        for (int i = 0, j = 0, jj = 0; i < A.length; i++) {
            while (map1.size() < K && j < A.length) {
                inc(map1, A[j++]);
            }
            while (map2.size() <= K && jj < A.length) {
                inc(map2, A[jj++]);
            }

            if (map1.size() == K) {
                if (map2.size() == K) {
                    // This means there we cannot find a window with K + 1 unique integers, hence every index in
                    // [j-1, A.length-1] is feasible.
                    ans += (A.length - 1) - (j - 1) + 1;
                } else {
                    // [j-1, jj-2]
                    ans += (jj - 2) - (j - 1) + 1;
                }
            }
            dec(map1, A[i]);
            dec(map2, A[i]);
        }
        return ans;

    }

    void inc(Map<Integer, Integer> map, int i) {
        map.put(i, map.getOrDefault(i, 0) + 1);
    }

    void dec(Map<Integer, Integer> map, int i) {
        if (map.put(i, map.get(i) - 1) == 1) {
            map.remove(i);
        }
    }
}

