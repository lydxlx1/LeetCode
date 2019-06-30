/**
 * Filling Bookcase Shelves
 *
 * DP
 */
public class FillingBookcaseShelves {

    public int minHeightShelves(int[][] books, int shelf_width) {
        return f(books.length - 1, books, shelf_width, new int[books.length]);
    }

    int f(int i, int[][] books, int W, int[] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] > 0) {
            return memo[i];
        }

        int res = Integer.MAX_VALUE;
        int totalWidth = 0, maxHeight = 0;
        for (int j = i; j >= 0; j--) {
            totalWidth += books[j][0];
            maxHeight = Math.max(maxHeight, books[j][1]);
            if (totalWidth <= W) {
                res = Math.min(res, f(j - 1, books, W, memo) + maxHeight);
            } else {
                break;
            }
        }
        memo[i] = res;
        return res;
    }
}
