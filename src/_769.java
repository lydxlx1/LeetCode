import java.util.*;

/**
 * LeetCode 769 - Max Chunks To Make Sorted (Ver 1)
 * <p>
 * Greedy Solution
 * <p>
 * Assume the original array is a_1, a_2, ..., a_n, and the sorted array is s_1, s_2, ..., s_n.
 * Then, the answer is equals to the number of indices i's, such that,
 * {a_1, a_2, ..., a_i} = {s_1, s_2, ..., s_i},
 * where {.} denotes the multiset function.
 */
public class _769 {

    public int maxChunksToSorted(int[] arr) {
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayDeque<>());
            map.get(arr[i]).add(i);
        }

        Arrays.sort(arr);
        int cnt = 0, maxInd = 0;
        for (int i = 0; i < arr.length; i++) {
            maxInd = Math.max(maxInd, map.get(arr[i]).pollFirst());
            if (i >= maxInd) {
                cnt++;
            }
        }
        return cnt;
    }
}



