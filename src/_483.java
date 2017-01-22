import java.math.BigInteger;

/**
 * LeetCode 483 - Smallest Good Base
 * <p>
 * Number of digits will be no more than 63 since the number formed by 63 one's in base-2 is already greater than n.
 * Then we can simply enumerate the length of the representation.
 */
public class _483 {
    public String smallestGoodBase(String n) {
        BigInteger N = new BigInteger(n);
        for (int k = 63; k >= 2; k--) {
            long l = 2, r = Long.MAX_VALUE - 5;
            while (l <= r) {
                long mid = l + (r - l) / 2;
                // Compare 1 + mid + mid^2 + ... + mid^(k-1) against n
                // (mid^k - 1) / (mid - 1) against n
                // mid^k - 1 against (mid - 1) * n
                BigInteger cb = BigInteger.valueOf(mid).pow(k).subtract(BigInteger.ONE);
                BigInteger wb = N.multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));

                int cmp = cb.compareTo(wb);
                if (cmp == 0) {
                    return "" + mid;
                } else if (cmp < 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        throw new RuntimeException("No solution for n = " + n);
    }
}
