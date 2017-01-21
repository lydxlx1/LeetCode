import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * LeetCode 484 - Find Permutation
 * <p>
 * Topological sort
 * Build the graph based on "<"-relation on a[i]'s.
 * <p>
 * When doing the topological-sort, use a priority queue to hold all the array indices such that
 * smaller index always comes first.
 * Therefore, we can assign smaller numbers to smaller indices, which enforces the lexico-order.
 */
public class _484 {

    static _484 sol = new _484();

    public int[] findPermutation(String s) {
        List<Integer>[] g = new List[s.length() + 1];
        int[] inDegree = new int[g.length];

        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int u, v;
            if (s.charAt(i) == 'I') {
                u = i;
                v = i + 1;
            } else {
                u = i + 1;
                v = i;
            }

            g[u].add(v);
            inDegree[v]++;
        }

        int[] ans = new int[s.length() + 1];
        int num = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // min-heap based on each position
        for (int i = 0; i < inDegree.length; i++)
            if (inDegree[i] == 0) queue.add(i);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            ans[u] = num++;

            for (int v : g[u]) {
                inDegree[v]--;
                if (inDegree[v] == 0) queue.add(v);
            }
        }

        return ans;
    }

    @Test
    public void test() {
        List<Integer> expected;
        List<Integer> actual;
        String s;

        s = "II";
        expected = Arrays.asList(1, 2, 3);
        actual = IntStream.of(sol.findPermutation(s)).boxed().collect(toList());
        assertEquals(expected, actual);

        s = "DD";
        expected = Arrays.asList(3, 2, 1);
        actual = IntStream.of(sol.findPermutation(s)).boxed().collect(toList());
        assertEquals(expected, actual);

        s = "DDDI";
        expected = Arrays.asList(4, 3, 2, 1, 5);
        actual = IntStream.of(sol.findPermutation(s)).boxed().collect(toList());
        assertEquals(expected, actual);

        s = "";
        expected = Arrays.asList(1);
        actual = IntStream.of(sol.findPermutation(s)).boxed().collect(toList());
        assertEquals(expected, actual);
    }
}
