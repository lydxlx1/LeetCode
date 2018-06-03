/**
 * LeetCode 844 - Backspace String Compare
 */
public class _844 {

    public boolean backspaceCompare(String S, String T) {
        return type(S).equals(type(T));
    }

    String type(String s) {
        StringBuffer buffer = new StringBuffer();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (buffer.length() > 0) {
                    buffer.deleteCharAt(buffer.length() - 1);
                }
            } else {
                buffer.append(ch);
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        _844 sol = new _844();


        System.out.println(sol.backspaceCompare("ab#c", "ad#c"));
        System.out.println(sol.backspaceCompare("ab##", "c#d#"));
        System.out.println(sol.backspaceCompare("a##c", "#a#c"));
        System.out.println(sol.backspaceCompare("a#c", "b"));

    }
}

