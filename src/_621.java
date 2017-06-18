import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * LeetCode 621 - Task Scheduler
 * <p>
 * Simulation + greedy
 */
public class _621 {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0)
            return 0;
        int[] cnt = new int[26];
        for (char ch : tasks)
            cnt[ch - 'A']++;

        if (n >= 25) {
            int max = IntStream.of(cnt).max().getAsInt();
            int nMax = (int) IntStream.of(cnt).filter(u -> u == max).count();
            return (n + 1) * (max - 1) + nMax;
        } else {
            int t = 0;
            int nTask = tasks.length;
            int[] pos = IntStream.of(new int[26]).map(u -> -1).toArray();
            Integer[] order = IntStream.range(0, 26).boxed().toArray(Integer[]::new);
            while (nTask > 0) {
                t++;
                Arrays.sort(order, Comparator.<Integer>comparingInt(u -> cnt[u]).reversed());
                for (int i : order) {
                    if (cnt[i] > 0 && (pos[i] == -1 || t - pos[i] >= n + 1)) {
                        pos[i] = t;
                        cnt[i]--;
                        nTask--;
                        break;
                    }
                }
            }
            return t;
        }
    }
}