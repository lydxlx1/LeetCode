/**
 * LeetCode 394 - Decode String
 *
 * Top-down approach
 */
public class _394 {
    int ptr;
    char[] a;

    private String repeatToken() {
        StringBuilder inner = new StringBuilder(), outer = new StringBuilder();
        int num = 0;
        while (Character.isDigit(a[ptr])) num = num * 10 + a[ptr++] - '0';
        ptr++; // skip [
        while (a[ptr] != ']')
            if (Character.isDigit(a[ptr])) inner.append(repeatToken());
            else inner.append(a[ptr++]);
        ptr++; // skip ]
        String innerStr = inner.toString();
        for (; num > 0; num--) outer.append(innerStr);
        return outer.toString();
    }

    public String decodeString(String s) {
        a = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (ptr = 0; ptr < s.length(); )
            if (Character.isDigit(a[ptr])) builder.append(repeatToken());
            else builder.append(a[ptr++]);
        return builder.toString();
    }
}