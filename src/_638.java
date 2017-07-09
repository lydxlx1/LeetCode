import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 638 - Shopping Offers
 * <p>
 * 6-dim Knapsack
 * It is better to encode each state to an integer to avoid high overhead of ArrayList, etc...
 */
public class _638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        final int MAX = (int) Math.pow(7, 6) + 10;
        final int[] memo = new int[MAX];

        int[] priceArr = price.stream().mapToInt(i -> i).toArray();
        int[][] specialArr = special.stream().map(list -> list.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);

        Arrays.fill(memo, -1);
        memo[0] = 0;

        class Solver {
            int dp(int[] needs) {
                int key = encode(needs);
                if (memo[key] != -1) return memo[key];


                int res = Integer.MAX_VALUE / 2;

                for (int[] arr : specialArr) {
                    boolean canUse = true;
                    for (int i = 0; i < needs.length; i++)
                        if (needs[i] < arr[i]) {
                            canUse = false;
                            break;
                        }
                    if (canUse) {
                        for (int i = 0; i < needs.length; i++)
                            needs[i] -= arr[i];

                        res = Math.min(res, dp(needs) + arr[arr.length - 1]);

                        for (int i = 0; i < needs.length; i++)
                            needs[i] += arr[i];
                    }
                }

                // Not use any special, directly buy...
                int val = 0;
                for (int i = 0; i < needs.length; i++)
                    val += needs[i] * priceArr[i];
                res = Math.min(res, val);

                memo[key] = res;
                return res;
            }

            private int encode(int[] arr) {
                int key = 0;
                for (int i : arr)
                    key = key * 7 + i;
                return key;
            }
        }
        return new Solver().dp(needs.stream().mapToInt(i -> i).toArray());
    }
}