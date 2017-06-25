import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 631 - Design Excel Sum Formula
 * <p>
 * DAG + Implementation
 * <p>
 * The sum-relation is indeed a dag, which must be solved via topological sort or dp.
 */
public class _631 {

    int[] val;
    Map<Integer, Integer> sum[];
    int H, W;
    long[] memo;

    public _631(int H, char W) {
        this.H = H;
        this.W = W - 'A' + 1;
        int n = this.H * this.W;
        val = new int[n];
        memo = new long[n];
        sum = new Map[n];
        for (int i = 0; i < n; i++)
            sum[i] = new HashMap<>();
    }

    public void set(int r, char c, int v) {
        int id = (r - 1) * W + (c - 'A');
        val[id] = v;
        sum[id].clear();
        Arrays.fill(memo, Long.MAX_VALUE);
    }


    public int get(int r, char c) {
        return myGet((r - 1) * W + c - 'A');
    }

    private int myGet(int id) {
        if (memo[id] == Long.MAX_VALUE) {
            if (sum[id].isEmpty())
                memo[id] = val[id];
            else {
                memo[id] = 0;
                for (int i : sum[id].keySet())
                    memo[id] += myGet(i) * sum[id].get(i);
            }
        }
        return (int) memo[id];
    }

    public int sum(int r, char c, String[] strs) {
        int id = (r - 1) * W + c - 'A';
        sum[id].clear();
        for (String s : strs) {
            if (s.contains(":")) {
                int id1 = strToId(s.split(":")[0]);
                int id2 = strToId(s.split(":")[1]);
                int r1 = id1 / W, r2 = id2 / W;
                int c1 = id1 % W, c2 = id2 % W;
                for (int i = r1; i <= r2; i++)
                    for (int j = c1; j <= c2; j++)
                        sum[id].put(i * W + j, sum[id].getOrDefault(i * W + j, 0) + 1);
            } else {
                int id1 = strToId(s);
                sum[id].put(id1, sum[id].getOrDefault(id1, 0) + 1);

            }
        }
        Arrays.fill(memo, Long.MAX_VALUE);
        return get(r, c);
    }

    private int strToId(String s) {
        int c = s.charAt(0) - 'A';
        int r = Integer.parseInt(s.substring(1)) - 1;
        return r * W + c;
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */