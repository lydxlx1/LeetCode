/**
 * LeetCode 755 - Reach a Number
 * <p>
 * Math
 * O(sqrt(n))-time
 */
public class _754 {

    public int reachNumber(int target) {
        target = Math.abs(target);
        long sum = 0;
        for (int i = 0; ; i++) {
            sum += i;
            // This is obviously a necessary condition, but it is not too difficult to show it is also sufficient.
            if (sum >= target && (sum - target) % 2 == 0) {
                return i;
            }
        }
    }
}



