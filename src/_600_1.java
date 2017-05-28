/**
 * LeetCode 600 - Non-negative Integers without Consecutive Ones
 * <p>
 * Digit-DP
 */
public class _600_1 {
    Integer[][] f;
    int num;

    int F(int len, boolean free) {
        if (len < 0)
            return 1;
        if (f[len][free ? 1 : 0] != null)
            return f[len][free ? 1 : 0];

        int high = free || (num & (1 << len)) != 0 ? 1 : 0;
        int res = F(len - 1, free || high > 0); // if the len-th bit is set to 0
        if (high > 0) {
            // if the len-th bit is set to 1, then the (len-1)-th bit must be 0 to avoid consecutive ones
            res += F(len - 2, free || (len - 1 >= 0 && (num & (1 << (len - 1))) != 0));
        }

        f[len][free ? 1 : 0] = res;
        return res;
    }

    public int findIntegers(int num) {
        f = new Integer[33][2];
        this.num = num;
        return F(31, false);
    }

    public static void main(String[] args) {
        System.out.println(new _600_1().findIntegers(1000000000));
    }
}
