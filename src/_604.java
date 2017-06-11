/**
 * LeetCode 604 - Design Compressed String Iterator
 * <p>
 * Lazy solution
 */
public class _604 {

    private final String s;
    private int i, cnt, ch;

    public _604(String compressedString) {
        this.s = compressedString;
        i = cnt = ch = 0;
    }

    public char next() {
        char res = ' ';
        if (hasNext()) {
            cnt--;
            res = (char) ch;
        }
        return res;
    }

    public boolean hasNext() {
        if (cnt == 0) {
            if (i < s.length()) {
                ch = s.charAt(i++);
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    cnt = cnt * 10 + s.charAt(i++) - '0';
            }
        }
        return cnt > 0;
    }
}