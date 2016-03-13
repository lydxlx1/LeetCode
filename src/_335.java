/**
 * LeetCode 335 - Self Crossing
 *
 * Geometry
 *
 * Based on how the spiral is define, there are three cases to have intersection.
 *
 *                                      ^------------>
 *                                      |            |
 *    ^                                 |            |
 *    |                                 |            |
 * *--+---->       ^--->  *---->        |      *-----+---->
 *    |    |       |           |        |            |    |
 *    |    |       |           |        |            v    |
 *    |    |       |           |        |                 |
 *    <----v       <-----------v        ------------------v
 *
 * ( "*" denotes the starting position. )
 * ( I just notice that the direction of the spiral is reversed,
 * but that should not affect the proposes of illustrating all the three different intersections.)
 *
 * Therefore, we can only keeps track of only O(1) amount of information as we proceed.
 */
public class _335 {
    public boolean isSelfCrossing(int[] delta) {
        int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
        int[] x = new int[7], y = x.clone(); // x[6] = y[6] = 0 is implicitly the first point
        for (int i=0; i<delta.length; i++) {
            x[i%7] = x[(i+6)%7] + delta[i] * dx[i % 4];
            y[i%7] = y[(i+6)%7] + delta[i] * dy[i % 4];
            System.out.println(x[i%7] + " " + y[i%7]);
            for (int j=2; j+1<7; j++)
                if (i>=j && _1D(x, i%7, (i-1+7)%7, (i-j+7)%7, (i-j-1+7)%7) && _1D(y, i%7, (i-1+7)%7, (i-j+7)%7, (i-j-1+7)%7)) return true;
        }
        return false;
    }

    private boolean _1D(int[] arr, int i, int j, int x, int y) {
        return Math.max(arr[i], arr[j]) >= Math.min(arr[x], arr[y]) && Math.max(arr[x], arr[y]) >= Math.min(arr[i], arr[j]);
    }
}
