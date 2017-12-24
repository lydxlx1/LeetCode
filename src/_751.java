import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * LeetCode 751 - IP to CIDR
 * <p>
 * Greedy + Bit Manipulation
 */
public class _751 {

    private String toString(long x) {
        StringJoiner joiner = new StringJoiner(".");
        for (long div : new long[]{1L << 24, 1L << 16, 1L << 8, 1L})
            joiner.add("" + (x / div % 256));
        return joiner.toString();
    }

    private long toLong(String ip) {
        long ans = 0;
        for (String token : ip.split("\\."))
            ans = ans * 256 + Integer.parseInt(token);
        return ans + (1L << 32);
    }

    public List<String> ipToCIDR(String ip, int range) {
        List<String> res = new ArrayList<>();
        long x = toLong(ip);
        while (range > 0) {
            int zeros = Long.numberOfTrailingZeros(x);
            while ((1L << zeros) > range)
                zeros--;
            res.add(toString(x) + "/" + (32 - zeros));
            range -= 1L << zeros;
            x += 1L << zeros;
        }
        return res;
    }
}

