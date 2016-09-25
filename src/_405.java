/**
 * LeetCode 405 - Convert a Number to Hexadecimal
 * <p>
 * Bit manipulation
 * <p>
 * Pay extreme attention to the difference between
 * num >> k and num >>> k, when num is positive and negative.
 * <p>
 * >> will pad the sign bit.
 * >>> will always pad zeros.
 */
public class _405 {
    public String toHex(int num) {
        if (num == 0) return "0";
        else {
            StringBuilder builder = new StringBuilder();
            while (num != 0) {
                builder.append("0123456789abcdef".charAt(num & 0b1111));
                num >>>= 4;
            }
            return builder.reverse().toString();
        }
    }
}