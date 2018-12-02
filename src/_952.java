/**
 * LeetCode 952 - Largest Component Size by Common Factor
 *
 * Math + Union-Find set
 * The code can be further optimized a bit by only enumerating prime factors.
 */
public class _952 {

    int max = 1000000 + 1;
    int[] parent;

    int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    void union(int i, int j) {
        parent[find(i)] = find(j);
    }

    public int largestComponentSize(int[] A) {
        parent = new int[max];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i : A) {
            for (int factor = 2; factor * factor <= i; factor++) {
                if (i % factor == 0) {
                    union(i, factor);
                    union(i, i / factor);
                }
            }
        }

        int ans = 0;
        int[] cnt = new int[max];
        for (int i : A) {
            cnt[find(i)]++;
            ans = Math.max(ans, cnt[find(i)]);
        }
        return ans;
    }
}

