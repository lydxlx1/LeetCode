/**
 * LeetCode 507 - Perfect Number
 * <p>
 * An O(sqrt(n))-time solution is not difficult to come up with.
 * Just need to be careful to the following corner cases:
 * 1) n <= 0,
 * 2) n is a perfect square.
 */
public class _507 {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int ans = 0;
        for (long i = 1; i * i <= num; i++)
            if (num % i == 0) {
                if (i < num) ans += i;
                if (i != num / i && num / i < num) ans += num / i;
            }
        return ans == num;
    }
}
