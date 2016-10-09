/**
 * LeetCode 415 - Add Strings
 * <p>
 * BigInteger Addition
 */
public class _415 {
    public String addStrings(String num1, String num2) {
        if (num1.equals("0") && num2.equals("0")) return "0";
        StringBuilder builder = new StringBuilder();
        int carry = 0, max = Math.max(num1.length(), num2.length());
        for (int i = 0; i < max; i++) {
            if (i < num1.length()) carry += num1.charAt(num1.length() - 1 - i) - '0';
            if (i < num2.length()) carry += num2.charAt(num2.length() - 1 - i) - '0';
            builder.append(carry % 10);
            carry /= 10;
        }
        if (carry > 0) builder.append(carry);
        return builder.reverse().toString();
    }
}