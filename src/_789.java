/**
 * LeetCode 789 - Escape the Ghosts
 * <p>
 * Math
 */
public class _789 {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int mine = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int other = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (other <= mine) {
                return false;
            }
        }
        return true;
    }
}
