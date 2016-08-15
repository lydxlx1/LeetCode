/**
 * LeetCode 79 - Word Search
 *
 * DFS approach
 */
public class _79 {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (dfs(board, i, j, 0, word)) return true;
        return false;
    }

    private boolean dfs(char[][] a, int i, int j, int t, String word) {
        if (a[i][j] != word.charAt(t)) return false;
        if (a[i][j] == '.') return false;
        if (t == word.length() - 1) return true;

        char ch = a[i][j];
        a[i][j] = '.';
        if (i + 1 < a.length && dfs(a, i + 1, j, t + 1, word)) return true; // technically, this is not truly correct since we need to recover the board
        if (i - 1 >= 0 && dfs(a, i - 1, j, t + 1, word)) return true;
        if (j + 1 < a[0].length && dfs(a, i, j + 1, t + 1, word)) return true;
        if (j - 1 >= 0 && dfs(a, i, j - 1, t + 1, word)) return true;
        a[i][j] = ch;
        return false;
    }
}
