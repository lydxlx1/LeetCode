import java.util.ArrayList;
import java.util.List;


/**
 * LeetCode 831 - Masking Personal Information
 */
public class _831 {

    public String maskPII(String S) {
        if (S.indexOf('@') >= 0) {
            String name1 = S.split("@")[0].toLowerCase();
            String rest = S.split("@")[1].toLowerCase();
            return "" + name1.charAt(0) + "*****" + name1.charAt(name1.length() - 1) + "@" + rest;
        } else {
            List<Character> digits = new ArrayList<>();
            for (char ch : S.toCharArray()) {
                if (Character.isDigit(ch)) {
                    digits.add(ch);
                }
            }

            String ans = "";
            if (digits.size() > 10) {
                ans = "+";
                for (int i = 0; i < digits.size() - 10; i++) {
                    ans += "*";
                }
                ans += "-";
            }

            ans += "***-***-";
            for (int i = digits.size() - 4; i < digits.size(); i++) {
                ans += digits.get(i);
            }

            return ans;
        }
    }
}

