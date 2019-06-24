import java.util.*;


/**
 * Brace Expansion II
 *
 * Treat "," as one operation, and {..}{..} as another operation, where unlike the "," case, the operator of Cartesian
 * is not shown explicitly but is implied from "}{" and the following tricky cases (due to the existence of singletons):
 * }a..., or ...a{
 *
 * One possible way to simplify the logic is to wrap every singleton with a pair of braces, i.e., a -> {a}.
 * This still preserves the correctness, but then the operator of Cartesian product can only be implied from "}{".
 *
 * By the way, although there are two operations in this expression, we don't need to care too much about precedence as
 * every component is nicely wrapped with at least one pair of braces.
 */
public class BraceExpansionII {

    public List<String> braceExpansionII(String expression) {
        expression = expression.replaceAll("([a-z]+)", "{$1}");

        Stack<Character> stack1 = new Stack<>();
        Stack<Set<String>> stack2 = new Stack();
        char[] s = expression.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '{' || s[i] == ',') {
                stack1.push(s[i]);
                // Condition for a cartesian product
                if (i - 1 >= 0 && s[i] == '{' && (s[i - 1] == '}')) {
                    stack1.push('+');
                }
            } else if (Character.isLetter(s[i])) {
                StringBuilder builder = new StringBuilder();
                for (int j = i; j < s.length; j++) {
                    if (Character.isLetter(s[j])) {
                        builder.append(s[j]);
                        i = j;
                    } else {
                        break;
                    }
                }
                stack2.add(new HashSet<>(Arrays.asList(builder.toString())));
            } else if (s[i] == '}') {
                while (stack1.peek() != '{') {
                    Set<String> set2 = stack2.pop();
                    Set<String> set1 = stack2.pop();
                    if (stack1.pop() == ',') {
                        // Heuristic: always merge the smaller set into the bigger one, which results in logarithmic runtime.
                        if (set1.size() < set2.size()) {
                            set2.addAll(set1);
                            stack2.add(set2);
                        } else {
                            set1.addAll(set2);
                            stack2.add(set1);
                        }
                    } else {
                        Set<String> set3 = new HashSet<>();
                        for (String a : set1) {
                            for (String b : set2) {
                                set3.add(a + b);
                            }
                        }
                        stack2.add(set3);
                    }
                }
                stack1.pop();
            } else {
                throw new RuntimeException("");
            }
        }
        return new ArrayList<>(new TreeSet<>(stack2.pop()));
    }
}
