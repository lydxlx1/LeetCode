import java.util.Arrays;

/**
 * LeetCode 756 - Pour Water
 * <p>
 * Just make sure you correctly understand the problem description.
 */
public class _756 {

    public int[] pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V; i++) {
            int tmp = moveLeft(heights, K);
            if (tmp != -1) {
                heights[tmp]++;
                continue;
            }

            tmp = moveRight(heights, K);
            if (tmp != -1) {
                heights[tmp]++;
                continue;
            }

            heights[K]++;
        }
        return heights;
    }

    int moveLeft(int[] a, int idx) {
        int ans = -1;

        for (int i = idx - 1; i >= 0; i--) {
            if (a[i] == a[i + 1]) {
                continue;
            } else if (a[i] < a[i + 1]) {
                ans = i;
            } else {
                break;
            }
        }

        return ans;
    }

    int moveRight(int[] a, int idx) {
        int ans = -1;

        for (int i = idx + 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                continue;
            } else if (a[i] < a[i - 1]) {
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        _756 sol = new _756();
        System.out.println(Arrays.toString(sol.pourWater(new int[]{2, 1, 1, 2, 1, 2, 2}, 4, 3)));
        System.out.println(Arrays.toString(sol.pourWater(new int[]{1, 2, 3, 4}, 2, 2)));
        System.out.println(Arrays.toString(sol.pourWater(new int[]{3, 1, 3}, 5, 1)));
    }
}



