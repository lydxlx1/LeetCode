import java.util.List;

/**
 * LeetCode 841 - Keys and Rooms
 * <p>
 * Just do a DFS or BFS.
 */
public class _841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return dfs(rooms, new boolean[rooms.size()], 0) == rooms.size();
    }

    private int dfs(List<List<Integer>> rooms, boolean[] visited, int i) {
        if (visited[i])
            return 0;
        visited[i] = true;
        return rooms.get(i).stream().mapToInt(j -> dfs(rooms, visited, j)).sum() + 1;
    }
}

