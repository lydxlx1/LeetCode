import java.util.stream.IntStream;

/**
 * LeetCode 679 - 24 Game
 * <p>
 * Backtracking
 * <p>
 * It is easier to think about this problem using a tree structure.
 * That is, the entire computation corresponds to a full binary tree, where
 * <p>
 * 1) there are four leaves, corresponding to the given four numbers, respectively.
 * 2) each non-leaf node stores an operator and also saves the intermediate result.
 * 3) the final result is stored at the root.
 * <p>
 * So, at each step, we can enumerate and consume two numbers, and then produce a new one.
 * Keep doing this step three times and there will be only one number left.
 */
class _679 {
    final static double EPS = 1e-8;

    public boolean judgePoint24(int[] nums) {
        return dfs(IntStream.of(nums).mapToDouble(i -> i).toArray());
    }

    private boolean dfs(double[] a) {
        if (a.length == 1) {
            return Math.abs(a[0] - 24) < EPS;
        } else {
            double[] b = new double[a.length - 1];

            for (int i = 0; i < a.length; i++)
                for (int j = 0; j < a.length; j++)
                    if (i != j) {
                        int len = 0;
                        for (int k = 0; k < a.length; k++) {
                            if (k != i && k != j) {
                                b[len++] = a[k];
                            }
                        }

                        b[len] = a[i] + a[j];
                        if (dfs(b)) return true;

                        b[len] = a[i] - a[j];
                        if (dfs(b)) return true;

                        b[len] = a[i] * a[j];
                        if (dfs(b)) return true;

                        if (Math.abs(a[j]) > EPS) {
                            b[len] = a[i] / a[j];
                            if (dfs(b)) return true;
                        }
                    }
            return false;
        }
    }
}