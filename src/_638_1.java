import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 638 - Shopping Offers
 * <p>
 * Searching + pruning
 */
public class _638_1 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        class Solver {
            int ans = Integer.MAX_VALUE;

            public Solver() {
                dfs(0, 0);
            }

            private void dfs(int t, int val) {
                if (val >= ans) return;

                int res = val;
                for (int i = 0; i < needs.size(); i++)
                    res += needs.get(i) * price.get(i);
                ans = Math.min(ans, res);

                if (t >= special.size()) return;

                int maxCnt = Integer.MAX_VALUE;
                List<Integer> arr = special.get(t);
                for (int i = 0; i < needs.size(); i++)
                    if (arr.get(i) > 0)
                        maxCnt = Math.min(maxCnt, needs.get(i) / arr.get(i));

                dfs(t + 1, val);
                for (int j = 0; j < maxCnt; j++) {
                    for (int i = 0; i < needs.size(); i++)
                        needs.set(i, needs.get(i) - arr.get(i));
                    val += arr.get(arr.size() - 1);
                    dfs(t + 1, val);
                }
                for (int i = 0; i < needs.size(); i++)
                    needs.set(i, needs.get(i) + maxCnt * arr.get(i));
            }
        }

        Solver solver = new Solver();
        return solver.ans;
    }

    public static void main(String[] args) {
        _638_1 sol = new _638_1();
        System.out.println(sol.shoppingOffers(
                Arrays.asList(2, 5),
                Arrays.asList(
                        Arrays.asList(3, 0, 5),
                        Arrays.asList(1, 2, 10)
                ),
                Arrays.asList(3, 2)
        ));
    }
}