import java.util.Arrays;

/**
 * LeetCode 406 - Queue Reconstruction by Height
 *
 * Greedy + Sorting
 */
public class _406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (u, v) -> u[0] == v[0] ? v[1] - u[1] : u[0] - v[0]); // increasing first, decreasing second
        int[][] ans = new int[people.length][];
        for (int i = 0; i < people.length; i++) {
            for (int j = 0, cnt = 0; j < people.length; j++)
                if (ans[j] == null) {
                    if (cnt++ == people[i][1]) {
                        ans[j] = people[i];
                        break;
                    }
                }
        }
        return ans;
    }
}