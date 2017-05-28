/**
 * LeetCode 565 - Array Nesting
 * <p>
 * The given constraints:
 * 1) 0 <= a[i] < N
 * 2) a[i] != a[j] if i != j
 * guarantee that the graph can only consist of several disjoint cycles.
 */
public class _565 {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int cnt = 1;
                visited[i] = true;
                for (int j = nums[i]; !visited[j]; j = nums[j]) {
                    cnt++;
                    visited[j] = true;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
