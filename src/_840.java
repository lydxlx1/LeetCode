import java.util.stream.IntStream;

/**
 * LeetCode 840 - Magic Squares in Grid
 */
public class _840 {

    public int numMagicSquaresInside(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i + 3 <= grid.length; i++)
            for (int j = 0; j + 3 <= grid[0].length; j++)
                if (isValid(grid, i, j))
                    cnt++;
        return cnt;

    }

    private boolean isValid(int[][] grid, int startX, int startY) {
        boolean[] mask = new boolean[10];
        int[] x = {startX, startX + 1, startX + 2};
        int[] y = {startY, startY + 1, startY + 2};

        for (int i : x)
            for (int j : y)
                if (grid[i][j] >= 1 && grid[i][j] <= 9)
                    mask[grid[i][j]] = true;

        if (IntStream.rangeClosed(1, 9).filter(i -> mask[i]).count() != 9)
            return false;

        for (int i : x)
            if (IntStream.of(y).map(j -> grid[i][j]).sum() != 15)
                return false;
        for (int j : y)
            if (IntStream.of(x).map(i -> grid[i][j]).sum() != 15)
                return false;

        return IntStream.range(0, 3).map(i -> grid[x[i]][y[i]]).sum() == 15
                && IntStream.range(0, 3).map(i -> grid[x[i]][y[2 - i]]).sum() == 15;
    }
}

