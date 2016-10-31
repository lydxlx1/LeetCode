import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode 444 - Sequence Reconstruction
 * <p>
 * Topological sort
 * At anytime, the size of the BFS queue should always be 1.
 */
public class _444 {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        List<Integer> oriList = IntStream.of(org).boxed().collect(Collectors.toList());
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] seq : seqs)
            for (int i : seq)
                inDegree.put(i, 0);
        if (!inDegree.keySet().equals(new HashSet<>(oriList))) return false;

        for (int[] seq : seqs)
            for (int i = 1; i < seq.length; i++) {
                int u = seq[i - 1], v = seq[i];
                g.putIfAbsent(u, new ArrayList<>());
                g.get(u).add(v);
                inDegree.put(v, inDegree.get(v) + 1);
            }
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> actualList = new ArrayList<>(oriList.size());
        for (int u : inDegree.keySet())
            if (inDegree.get(u) == 0) queue.add(u);
        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false;
            int u = queue.poll();
            actualList.add(u);
            if (g.containsKey(u))
                for (int v : g.get(u))
                    if (inDegree.put(v, inDegree.get(v) - 1) == 1) queue.add(v);
        }
        return oriList.equals(actualList);
    }
}