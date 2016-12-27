/**
 * LeetCode 261 - Graph Valid Tree
 * <p>
 * Union-find Set
 */
public class _353 {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        class UnionFindSet {
            final int[] parent;

            public UnionFindSet(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) parent[i] = i;
            }

            public int find(int i) {
                if (parent[i] != i) parent[i] = find(parent[i]);
                return parent[i];
            }

            public void union(int i, int j) {
                parent[find(i)] = parent[find(j)];
            }
        }

        UnionFindSet set = new UnionFindSet(n);
        for (int[] edge : edges)
            set.union(edge[0], edge[1]);
        for (int i = 0; i < n; i++)
            if (set.find(0) != set.find(i)) return false;
        return true;
    }
}