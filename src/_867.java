import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 867 - Prime Palindrome
 * <p>
 * Fast Primality Test
 * <p>
 * - Use numerical calculation to revert a number when concatenate each palindrome.
 * - Use fast primality test as the number range is pretty small.
 */
public class _867 {

    static List<Integer> cand = new ArrayList<>();
    static int CERTAINTY = 32;

    static {
        cand.addAll(Arrays.asList(2, 3, 5, 7));

        // Odd-length
        loop:
        {
            for (int prefix = 1; ; prefix++) {
                for (int mid = 0; mid < 10; mid++) {
                    int len = (int) Math.log10(prefix) + 1;
                    long palindrome = prefix * 10 + mid, tmp = prefix;
                    for (int i = 0; i < len; i++) {
                        palindrome = palindrome * 10 + tmp % 10;
                        tmp /= 10;
                    }

                    if (palindrome > Integer.MAX_VALUE) {
                        break loop;
                    }
                    if (BigInteger.valueOf(palindrome).isProbablePrime(CERTAINTY)) {
                        cand.add((int) palindrome);
                    }
                }

            }
        }

        // Even-length
        for (int prefix = 1; ; prefix++) {
            int len = (int) Math.log10(prefix) + 1;
            long palindrome = prefix, tmp = prefix;
            for (int i = 0; i < len; i++) {
                palindrome = palindrome * 10 + tmp % 10;
                tmp /= 10;
            }

            if (palindrome > Integer.MAX_VALUE) {
                break;
            }
            if (BigInteger.valueOf(palindrome).isProbablePrime(CERTAINTY)) {
                cand.add((int) palindrome);
            }
        }

        Collections.sort(cand);
    }

    public int primePalindrome(int N) {
        for (int i : cand) {
            if (i >= N) {
                return i;
            }
        }
        throw new RuntimeException();
    }
}

