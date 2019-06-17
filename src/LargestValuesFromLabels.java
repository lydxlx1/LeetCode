import java.util.Arrays;
import java.util.Comparator;


/**
 * Largest Values From Labels
 *
 * Greedy
 */
public class LargestValuesFromLabels {

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int[] cnt = new int[22222];
        Integer[] rank = new Integer[values.length];
        for (int i = 0; i < rank.length; i++) {
            rank[i] = i;
        }
        Arrays.sort(rank, Comparator.<Integer>comparingInt(i -> values[i]).reversed().thenComparingInt(i -> i));

        int ans = 0, total = 0;
        for (int i : rank) {
            if (cnt[labels[i]] < use_limit) {
                ans += values[i];
                cnt[labels[i]]++;
                total++;
                if (total >= num_wanted) {
                    break;
                }
            }
        }
        return ans;
    }
}
