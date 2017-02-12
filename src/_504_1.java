/**
 * LeetCode 504 - Base 7
 * <p>
 * Conventional method
 */
public class _504_1 {

    public String convertTo7(int num) {
        if (num == 0) return "0";
        String sign = num < 0 ? "-" : "";
        StringBuilder builder = new StringBuilder();
        num = Math.abs(num);
        while (num > 0) {
            builder.append("" + (num % 7));
            num /= 7;
        }
        return sign + builder.reverse().toString();
    }
}
