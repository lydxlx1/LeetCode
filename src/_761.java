import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * LeetCode 761 - Special Binary String
 * <p>
 * Greedy + Stack
 */
public class _761 {

    public String makeLargestSpecial(String S) {
        Stack<List<String>> stack = new Stack<>();
        stack.add(new ArrayList<>());
        for (char ch : S.toCharArray()) {
            if (ch == '1') {
                stack.add(new ArrayList<>());
            } else {
                String str = "1" + reduce(stack.pop()) + "0";
                stack.peek().add(str);
            }
        }
        return reduce(stack.peek());
    }

    private String reduce(List<String> strings) {
        StringBuilder builder = new StringBuilder();
        for (String s : strings.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
            builder.append(s);
        }
        return builder.toString();
    }
}



