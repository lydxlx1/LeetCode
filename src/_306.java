/**
 * LeetCode 306 - Additive Number
 *
 * Similar to Fibonacci sequence, if the first two numbers are determined, then the entire sequence is fixed.
 */
import java.math.BigInteger;

public class _306 {

    private boolean isok(String num, BigInteger a, BigInteger b) {
        String ans = a.toString() + b.toString();
        while(ans.length() < num.length()) {
            ans += a.add(b).toString();
            BigInteger c = a.add(b);
            a = b;
            b = c;
        }
        return ans.equals(num);
    }

    public boolean isAdditiveNumber(String num) {
        for (int i=0; i<num.length(); i++)
            for (int j=i+1; j<num.length() - 1; j++) {
                String second = num.substring(i + 1, j + 1);
                if (second.length() > 1 && second.charAt(0) == '0') continue;
                if (isok(num, new BigInteger(num.substring(0, i+1)), new BigInteger(second))) return true;
            }
        return false;
    }
}