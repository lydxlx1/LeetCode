import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode 433 - Minimum Genetic Mutation
 * <p>
 * BFS
 */
public class _433 {

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;

        char[] bases = "ACGT".toCharArray();
        Map<String, Integer> dist = new HashMap<>();
        for (String gene : bank) dist.put(gene, Integer.MAX_VALUE);
        if (!dist.containsKey(end)) return -1;

        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        dist.put(start, 0);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            char[] ch = str.toCharArray();
            int d = dist.get(str);
            dist.remove(str);

            for (int i = 0; i < ch.length; i++) {
                char tmp = ch[i];
                for (char base : bases) {
                    if (base == tmp) continue;
                    ch[i] = base;
                    String newStr = String.copyValueOf(ch);
                    if (dist.containsKey(newStr) && dist.get(newStr) == Integer.MAX_VALUE) {
                        if (newStr.equals(end)) return d + 1;
                        queue.add(newStr);
                        dist.put(newStr, d + 1);
                    }
                }
                ch[i] = tmp;
            }

        }
        return -1;
    }
}
