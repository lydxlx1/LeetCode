import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode 760 - Find Anagram Mappings
 * <p>
 * Solution
 */
public class _760 {

    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.putIfAbsent(B[i], new ArrayDeque<>());
            map.get(B[i]).add(i);
        }

        int[] res = A.clone();
        for (int i = 0; i < A.length; i++) {
            res[i] = map.get(A[i]).poll();
        }
        return res;
    }


    public static void main(String[] args) {
    }
}



