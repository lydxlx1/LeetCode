/**
 * LeetCode 794 - Valid Tic-Tac-Toe State
 */
public class _794 {

    public boolean validTicTacToe(String[] board) {
        char[][] a = new char[3][];
        for (int i = 0; i < 3; i++)
            a[i] = board[i].toCharArray();


        int x = cnt(a, 'X');
        int o = cnt(a, 'O');
        if (x == o) {
            return !win(a, 'X');
        } else if (x - 1 == o) {
            return !win(a, 'O');
        } else {
            return false;
        }
    }

    private int cnt(char[][] a, char x) {
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] == x) {
                    cnt++;
                }
        }
        return cnt;
    }

    private boolean win(char[][] a, char x) {
        // Check each row
        for (int i = 0; i < 3; i++) {
            if (a[i][0] == x && a[i][1] == x && a[i][2] == x) {
                return true;
            }
        }
        // Check each column
        for (int j = 0; j < 3; j++) {
            if (a[0][j] == x && a[1][j] == x && a[2][j] == x) {
                return true;
            }
        }
        // Check the main diagonal
        if (a[0][0] == x && a[1][1] == x && a[2][2] == x) {
            return true;
        }
        // Check the other diagonal
        if (a[0][2] == x && a[1][1] == x && a[2][0] == x) {
            return true;
        }
        return false;
    }
}
