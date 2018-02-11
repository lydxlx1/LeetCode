/**
 * LeetCode 780 - Reaching Points
 * <p>
 * If we think about the problem in the forward way, the searching space will quickly explode.
 * Surprisingly, we think about the problem backwards, the searching path is UNIQUE.
 * <p>
 * Also, prefer division to subtraction.
 */
public class _780 {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return true;
        }
        if (sx > tx || sy > ty) {
            return false;
        }
        if (tx >= ty) {
            int step = Math.max(1, Math.min((tx - ty) / ty, (tx - sx) / ty));
            return reachingPoints(sx, sy, tx - step * ty, ty);
        } else {
            return reachingPoints(sy, sx, ty, tx);

        }
    }
}
