import java.util.Arrays;

/**
 * LeetCode 370 Range Addition
 *
 * Sweepline algorithm
 */
public class _370_1 {

    public int[] getModifiedArray(int length, int[][] updates) {
        int n = updates.length;
        int[] ans = new int[length];
        int[][] events = new int[2 * n][];
        for (int i = 0; i < n; i++) {
            events[i] = new int[]{updates[i][0], updates[i][2], 0};
            events[n + i] = new int[]{updates[i][1], updates[i][2], 1};
        }
        Arrays.sort(events, (u, v) -> u[0] != v[0] ? u[0] - v[0] : u[2] - v[2]);
        for (int i = 0, j = 0, sum = 0; i < ans.length; i++) {
            while (j < events.length && events[j][0] == i && events[j][2] == 0) sum += events[j++][1];
            ans[i] = sum;
            while (j < events.length && events[j][0] == i) sum -= events[j++][1]; // invariant: events[j][2] == i
        }
        return ans;
    }

    public static void main(String[] args) {
        _370_1 sln = new _370_1();
        int[][] a = {{1,3,2},{2,4,3},{0,2,-2}};
        int[] ans = sln.getModifiedArray(5, a);
        System.out.println(Arrays.toString(ans));
    }
}