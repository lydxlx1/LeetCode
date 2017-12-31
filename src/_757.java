import java.util.BitSet;
import java.util.List;

/**
 * LeetCode 757 - Pyramid Transition Matrix
 * <p>
 * DP
 * Note that each string pattern in the list allowed can be used multiple times.
 */
public class _757 {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        BitSet[][] go = new BitSet[26][26];
        for (int i = 0; i < go.length; i++)
            for (int j = 0; j < go.length; j++)
                go[i][j] = new BitSet(26);
        for (String s : allowed)
            go[s.charAt(0) - 'A'][s.charAt(1) - 'A'].set(s.charAt(2) - 'A');

        int n = bottom.length();
        BitSet[][] f = new BitSet[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                f[i][j] = new BitSet(26);

        for (int i = 0; i < n; i++) {
            f[n - 1][i].set(bottom.charAt(i) - 'A');
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // f[i][j] relies on f[i+1][j] and f[i+1][j+1]
                for (int ii = f[i + 1][j].nextSetBit(0); ii != -1; ii = f[i + 1][j].nextSetBit(ii + 1))
                    for (int jj = f[i + 1][j + 1].nextSetBit(0); jj != -1; jj = f[i + 1][j + 1].nextSetBit(jj + 1))
                        f[i][j].or(go[ii][jj]);
            }
        }
        return f[0][0].cardinality() > 0;
    }
}



