import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * LeetCode 425 - Word Squares
 * <p>
 * Backtracking with heuristic pruning + BitSet
 */
public class _425 {

    List<List<String>> ans;
    String[] board;
    String[] words;
    BitSet[] cand;
    BitSet[][] invalid;
    int n, m;

    private void dfs(int t) {
        if (t >= m) ans.add(new ArrayList<>(Arrays.asList(board)));
        else {
            int which = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++)
                if (board[i] == null && cand[i].cardinality() < min) {
                    min = cand[i].cardinality();
                    which = i;
                }
            if (min == 0) return;
            for (int i = 0; i < m; i++) invalid[t][i] = new BitSet(n);
            for (int i = cand[which].nextSetBit(0); i != -1; i = cand[which].nextSetBit(i + 1)) {
                board[which] = words[i];
                for (int otherRow = 0; otherRow < m; otherRow++)
                    if (board[otherRow] == null) {
                        for (int j = cand[otherRow].nextSetBit(0); j != -1; j = cand[otherRow].nextSetBit(j + 1))
                            if (board[which].charAt(otherRow) != words[j].charAt(which)) invalid[t][otherRow].set(j);
                        cand[otherRow].andNot(invalid[t][otherRow]);
                    }
                dfs(t + 1);
                for (int otherRow = 0; otherRow < m; otherRow++)
                    if (board[otherRow] == null) {
                        cand[otherRow].or(invalid[t][otherRow]);
                        invalid[t][otherRow].clear();
                    }
            }
            board[which] = null;
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        if (words.length == 0) return new ArrayList<>();
        n = words.length;
        m = words[0].length();
        this.words = words;
        cand = new BitSet[m];
        for (int i = 0; i < m; i++) {
            cand[i] = new BitSet(n);
            cand[i].flip(0, n);
        }
        invalid = new BitSet[m][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                invalid[i][j] = new BitSet(n);
        board = new String[m];
        ans = new ArrayList<>();
        dfs(0);
        return ans;
    }
}
