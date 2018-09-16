import java.util.Set;
import java.util.TreeSet;


/**
 * LeetCode 906 - Super Palindromes
 *
 * Just generate all the candidates under 10^18.
 */
public class _906 {

    static Set<Long> superPalindromes = new TreeSet<>();

    static long reverse(long n) {
        long reverse = 0;
        while (n > 0) {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        return reverse;
    }

    static boolean isPalindrome(long n) {
        return n == reverse(n);
    }

    static long pow(long n) {
        long pow = 1;
        while (n > 0) {
            pow *= 10;
            n /= 10;
        }
        return pow;
    }

    static {
        // Length = 1
        for (int i = 1; i <= 9; i++) {
            if (isPalindrome(i * i)) {
                superPalindromes.add(1L * i * i);
            }
        }

        for (int i = 1; i < 100000; i++) {
            long first = i, last = reverse(first), pow = pow(first);

            // Even length
            long palin = first * pow + last;
            if (palin <= Integer.MAX_VALUE && isPalindrome(palin * palin)) {
                superPalindromes.add(palin * palin);
            }

            // Odd length
            for (int j = 0; j < 10; j++) {
                palin = (first * 10 + j) * pow + last;
                if (palin <= Integer.MAX_VALUE && isPalindrome(palin * palin)) {
                    superPalindromes.add(palin * palin);
                }
            }
        }
    }


    public int superpalindromesInRange(String L, String R) {
        long l = Long.parseLong(L);
        long r = Long.parseLong(R);
        return (int) superPalindromes.stream().filter(palin -> palin >= l && palin <= r).count();
    }
}

