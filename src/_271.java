import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 271 - Encode and Decode Strings
 *
 * Escaping Method
 */
public class _271 {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            // ,, => delimiter
            // ,. => ,
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                builder.append(ch == ',' ? ",." : ch);
            }
            builder.append(",,");
        }
        return builder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ',') builder.append(ch);
            else {
                i++;
                if (s.charAt(i) == '.') builder.append(ch);
                else {
                    res.add(builder.toString());
                    builder = new StringBuilder();
                    continue;
                }
            }
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));