import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * LeetCode 870 - Advantage Shuffle
 * <p>
 * Greedy + Mergesort
 */
public class _870 {

    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        int[] sortedAIndices = IntStream.range(0, n).boxed().sorted(Comparator.comparingInt(i -> A[i])).mapToInt(i -> i).toArray();
        int[] sortedBIndices = IntStream.range(0, n).boxed().sorted(Comparator.comparingInt(i -> B[i])).mapToInt(i -> i).toArray();

        int[] res = IntStream.range(0, n).map(i -> -1).toArray();
        Queue<Integer> unused = new ArrayDeque<>();
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (A[sortedAIndices[i]] > B[sortedBIndices[j]]) {
                res[sortedBIndices[j]] = A[sortedAIndices[i]];
                i++;
                j++;
            } else {
                unused.add(A[sortedAIndices[i]]);
                i++;
            }
        }
        for (i = 0; i < n; i++) {
            if (res[i] == -1) {
                res[i] = unused.poll();
            }
        }
        return res;
    }
}

