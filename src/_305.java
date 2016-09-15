import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 305 - Number of Island II
 *
 * Union-Find Set
 */
public class _305 {
    int[] parent;
    int islandCnt = 0;

    int find(int i) {
        return parent[i] == i ? i : (parent[i] = find(parent[i]));
    }

    void union(int i, int j) {
        if (find(i) != find(j)) {
            parent[find(i)] = find(j);
            islandCnt--;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        parent = new int[m * n];
        Arrays.fill(parent, -1);

        List<Integer> ans = new ArrayList<>(positions.length);
        islandCnt = 0;
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0], y = positions[i][1], pos = x * n + y;
            parent[pos] = pos;
            islandCnt++;

            if (x - 1 >= 0 && parent[pos - n] != -1) union(pos, pos - n);
            if (x + 1 < m && parent[pos + n] != -1) union(pos, pos + n);
            if (y - 1 >= 0 && parent[pos - 1] != -1) union(pos, pos - 1);
            if (y + 1 < n && parent[pos + 1] != -1) union(pos, pos + 1);

            ans.add(islandCnt);
        }
        return ans;
    }
}