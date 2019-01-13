import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * LeetCode 976 - Odd Even Jump
 *
 * DP
 */
public class _975 {

    public int oddEvenJumps(int[] A) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        boolean[][] f = new boolean[A.length][2];
        f[A.length - 1][0] = f[A.length - 1][1] = true;

        tree.put(A[A.length - 1], A.length - 1);
        for (int i = A.length - 2; i >= 0; i--) {
            if (tree.ceilingEntry(A[i]) != null) {
                f[i][1] = f[tree.ceilingEntry(A[i]).getValue()][0];
            }
            if (tree.floorEntry(A[i]) != null) {
                f[i][0] = f[tree.floorEntry(A[i]).getValue()][1];
            }
            tree.put(A[i], i);
        }
        return (int) IntStream.range(0, A.length).filter(i -> f[i][1]).count();
    }
}
