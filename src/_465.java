import java.util.*;

/**
 * LeetCode 465 - Optimal Account Balancing
 * <p>
 * Very good NPC problem that can be solved via subset-sum problem
 * <p>
 * For each vertex, consider the sum of all its incoming balance and outgoing balance.
 * If incoming = outgoing, this vertex is useless and can be simply ignored.
 * <p>
 * Then, collect all the differences of incoming - outgoing as a multiset.
 * Note that the sum of the multiset is zero.
 * <p>
 * We want to do minimum # of additions to sum up the set.
 * At each time, we extract two numbers from the multiset and sum them up.
 * After summing each pair of number, we need to put it back into the multiset unless it is equal to zero.
 * <p>
 * This essentially boils down to the famous NPC problem subset-sum.
 * The more zero-sum subsets we identify from the original multiset, the smaller number of transactions we have to make.
 */
public class _465 {

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        for (int[] transaction : transactions) {
            int u = transaction[0], v = transaction[1], w = transaction[2];
            in.put(v, in.getOrDefault(v, 0) + w);
            out.put(u, out.getOrDefault(u, 0) + w);
        }

        List<Integer> a = new ArrayList<>();
        Set<Integer> vertices = new HashSet<>();
        vertices.addAll(in.keySet());
        vertices.addAll(out.keySet());
        for (int vertex : vertices) {
            int inValue = in.getOrDefault(vertex, 0);
            int outValue = out.getOrDefault(vertex, 0);
            if (inValue != outValue) {
                a.add(inValue - outValue);
            }
        }
        int[] arr = new int[a.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = a.get(i);


        // Compute all the subset that sums up to zero by brute-force
        boolean[] isZero = new boolean[1 << arr.length];
        int zeroCnt = 0;
        for (int mask = 0; mask < isZero.length; mask++) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++)
                if (((1 << i) & mask) != 0) {
                    sum += arr[i];
                }
            if (sum == 0) {
                isZero[mask] = true;
                zeroCnt++;
            }
        }
        int[] zero = new int[zeroCnt];
        for (int i = 0, j = 0; i < isZero.length; i++)
            if (isZero[i]) zero[j++] = i;


        // Do the DP by enumerating all the possible splits
        // S = S1 U S2, where sum(S) = sum(S1) = sum(S2) = 0
        // f[S] = min(f[S1] + f[S2])
        // If we cannot further split S into smaller subsets, then the answer is |S| - 1.
        int[] dp = new int[1 << arr.length];
        for (int mask = 1; mask < dp.length; mask++)
            if (isZero[mask]) {
                dp[mask] = Integer.bitCount(mask) - 1;
                for (int subset : zero)
                    if ((subset | mask) == mask) {
                        dp[mask] = Math.min(dp[mask], dp[subset] + dp[mask ^ subset]);
                    }
            }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        _465 sol = new _465();
        int[][] a = {
                {0, 1, 10},
                {1, 0, 1},
                {1, 2, 5},
                {2, 0, 5},
        };
        System.out.println(sol.minTransfers(a));

    }

}