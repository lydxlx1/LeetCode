/**
 * LeetCode 592 - Fraction Addition and Subtraction
 * <p>
 * An straightforward solution
 */
public class _592 {
    int ptr;
    String s;

    public String fractionAddition(String expression) {
        ptr = 0;
        s = expression;
        long[] res = {0, 1};
        while (ptr < s.length()) {
            int sign = 1;
            if (s.charAt(ptr) == '+') {
                ptr++;
            }
            if (s.charAt(ptr) == '-') {
                sign = -1;
                ptr++;
            }

            long numerator = nextNumber();
            ptr++; // skip '/'
            long denominator = nextNumber();
            res = add(res, new long[]{sign * numerator, denominator});
        }

        if (res[1] < 0) {
            res[0] = -res[0];
            res[1] = -res[1];
        }
        return res[0] + "/" + res[1];
    }

    private long[] add(long[] a, long[] b) {
        long[] c = {a[0] * b[1] + a[1] * b[0], a[1] * b[1]};
        if (c[0] == 0)
            c[1] = 1;
        else {
            long gcd = gcd(c[0], c[1]); // It is fine even when gcd is negative...
            c[0] /= gcd;
            c[1] /= gcd;
        }
        return c;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long nextNumber() {
        long res = 0;
        while (ptr < s.length() && Character.isDigit(s.charAt(ptr)))
            res = res * 10 + s.charAt(ptr++) - '0';
        return res;
    }
}