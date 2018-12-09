import java.util.stream.IntStream;

/**
 * LeetCode 955 - Delete Columns to Make Sorted II
 *
 * Recursive approach with strong prunings
 */
public class _955 {

    boolean[] deleted;
    int m = 0;

    public int minDeletionSize(String[] A) {
        m = A[0].length();
        deleted = new boolean[m];

        dfs(A, 0, A.length - 1, 0);
        return (int) IntStream.range(0, m).filter(i -> deleted[i]).count();
    }

    void dfs(String[] A, int begin, int end, int t) {
        if (end - begin + 1 <= 1 || t >= m) {
            return;
        }
        if (deleted[t]) {
            // This column has already been deleted, so continue with the next one.
            dfs(A, begin, end, t + 1);
        } else {
            for (int i = begin; i < end; i++) {
                if (A[i].charAt(t) > A[i + 1].charAt(t)) {
                    deleted[t] = true;
                    dfs(A, begin, end, t + 1);
                    return; // Another pruning
                }
            }

            for (int i = begin; i <= end; ) {
                int j = i;
                while (j + 1 <= end && A[i].charAt(t) == A[j + 1].charAt(t)) {
                    j++;
                }
                dfs(A, i, j, t + 1);

                i = j + 1;
            }
        }
    }
}

