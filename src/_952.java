import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 952 - Largest Component Size by Common Factor
 *
 * Math + Union-Find set
 * The code can be further optimized a bit by only enumerating prime factors.
 */
public class _952 {

    Map<Integer, Integer> parent;
    Map<Integer, Integer> factorCluster;

    int find(int i) {
        if (parent.get(i) != i) {
            parent.put(i, find(parent.get(i)));
        }
        return parent.get(i);
    }

    void union(int i, int j) {
        parent.put(find(i), find(j));
    }


    public int largestComponentSize(int[] A) {
        Arrays.sort(A);
        parent = new HashMap<>();
        factorCluster = new HashMap<>();
        for (int i : A) {
            parent.put(i, i);
        }

        for (int i : A) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    int factor = j;
                    if (factorCluster.containsKey(factor)) {
                        union(i, factorCluster.get(factor));
                    } else {
                        factorCluster.put(factor, i);
                    }

                    factor = i / j;
                    if (factorCluster.containsKey(factor)) {
                        union(i, factorCluster.get(factor));
                    } else {
                        factorCluster.put(factor, i);
                    }
                }
            }
            if (isPrime) {
                factorCluster.put(i, i);
            }
        }

        Map<Integer, Integer> cluster = new HashMap<>();
        int ans = 0;
        for (int i : A) {
            int p = find(i);
            cluster.put(p, cluster.getOrDefault(p, 0) + 1);
            ans = Math.max(ans, cluster.get(p));
        }

//        for (int i : A) {
//            System.out.println(i + " " + find(i));
//        }
//        System.out.println();
        return ans;
    }

    public static void main(String[] args) {
        _952 sol = new _952();
        System.out.println(sol.largestComponentSize(new int[]{4, 6, 15, 35}));
        System.out.println(sol.largestComponentSize(new int[]{20, 50, 9, 63}));
        System.out.println(sol.largestComponentSize(new int[]{2, 3, 6, 7, 4, 12, 21, 39}));
    }
}

