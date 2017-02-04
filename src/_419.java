import static org.junit.Assert.assertEquals;

/**
 * LeetCode 419 - Battleships in a Board
 * <p>
 * - Single pass
 * - O(1) space
 * - No modification to the original array
 */
public class _419 {

    public int countBattleships(char[][] board) {
        int cnt = 0;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == 'X') {
                    if ((i == 0 || board[i - 1][j] == '.') && (i == board.length - 1 || board[i + 1][j] == '.')) {
                        // horizontal rectangle can be uniquely represented by its leftmost X
                        if (j == 0 || board[i][j - 1] == '.') cnt++;
                    } else {
                        // vertical rectangle can be uniquely represented by its upmost X
                        if (i == 0 || board[i - 1][j] == '.') cnt++;
                    }
                }
        return cnt;
    }

    public static void main(String[] args) {
        char[][] board = {
                "X..X".toCharArray(),
                "...X".toCharArray(),
                "...X".toCharArray(),
        };
        assertEquals(2, new _419().countBattleships(board));

        board = new char[][]{
                ".X.X".toCharArray(),
                "X.X.".toCharArray(),
                ".X.X".toCharArray(),
                "X.X.".toCharArray(),
        };
        assertEquals(8, new _419().countBattleships(board));
    }
}
