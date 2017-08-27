/**
 * LeetCode 668 - Kth Largest Number in Multiplication Table
 * <p>
 * Binary Search
 */
class _668 {
    /**
     * @return the largest rank of value
     * <p>
     * Runtime = O(min(r, c))
     */
    private int rank(int r, int c, int value) {
        if (c > r) {
            return rank(c, r, value);
        }
        int cnt = 0;
        for (int i = 1; i <= c; i++) {
            cnt += Math.min(r, value / i);
        }
        return cnt;
    }

    /**
     * Alternative approach to compute the rank using the Young Tableau property.
     * Runtime = O(r + c)
     */
    private int rank1(int r, int c, int value) {
        int cnt = 0, i = r, j = 1;
        while (i >= 1 && j <= c) {
            if (i * j <= value) {
                cnt += i;
                j++;
            } else {
                i--;
            }
        }
        return cnt;
    }

    public int findKthNumber(int m, int n, int k) {
        // left: strictly less than the value at rank-k
        // right: no less than the value at rank-k
        int left = 0, right = m * n;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (rank(m, n, mid) < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        _668 sol = new _668();
        {
            int r = 3, c = 3;
            for (int i = 1; i <= r * c; i++) {
                System.out.println(sol.findKthNumber(r, c, i));
            }
        }
        System.out.println();
        {
            int r = 2, c = 3;
            for (int i = 1; i <= r * c; i++) {
                System.out.println(sol.findKthNumber(r, c, i));
            }
        }

    }
}