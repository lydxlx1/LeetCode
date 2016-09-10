import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Yuan on 9/10/2016.
 */
public class _37Test {
    @Test
    public void test() {
        _37 sol = new _37();
        String[] board = {"..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.."};
        char[][] board1 = new char[board.length][];
        for (int i = 0; i < board1.length; i++) board1[i] = board[i].toCharArray();
        sol.solveSudoku(board1);

        // Verify the result
        int emptySlot = 0;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board1[i][j] == '.') emptySlot++;
        assertTrue(emptySlot == 0);
        assertTrue((new _36()).isValidSudoku(board1));
    }
}