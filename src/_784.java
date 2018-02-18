import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode 784 - Letter Case Permutation
 */
public class _784 {


    public List<String> letterCasePermutation(String S) {
        Set<String> set = new HashSet<>();
        for (int mask = 0; mask < (1 << S.length()); mask++) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                char ch = ((1 << i) & mask) == 0 ? Character.toLowerCase(S.charAt(i)) : Character.toUpperCase(S.charAt(i));
                builder.append(ch);
            }
            set.add(builder.toString());
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        _784 sol = new _784();
    }
}
