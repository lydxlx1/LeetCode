import java.util.*;

/**
 * LeetCode 332 - Reconstruct Itinerary
 *
 * O(E log E) Euler Path
 *
 * If we treat each ticket as a direct edge from from to to.
 * We then have a direct graph, where nodes are airports and edges are tickets.
 * The goal is to compute the lexicographically smallest Euler Path/Tour that starts from JFK.
 * One can apply the so-called cycle finding algorithm to construct an Euler Path/Tour.
 * In order to find the lexicographically smallest one, we just need to follow the lexico-order during each DFS call.
 *
 * The cycle finding algorithm takes O(E) time, where E is the number of edges in the graph, or equivalently, the number of tickets.
 * However, sorting all the adjacency linked lists requires O(E log E) time. So, the overall runtime is O(E log E).
 */
public class _332 {

    Map<String, PriorityQueue<String>> graph;
    Deque<String> ans;

    private void dfs(String from) {
        while (graph.containsKey(from) && !graph.get(from).isEmpty())
            dfs(graph.get(from).poll());
        ans.addFirst(from);
    }

    public List<String> findItinerary(String[][] tickets) {
        graph = new HashMap<>();
        for (String[] ticket : tickets)
            graph.computeIfAbsent(ticket[0], u -> new PriorityQueue<>()).add(ticket[1]);
        ans = new LinkedList();
        dfs("JFK");
        return (List) ans;
    }
}

