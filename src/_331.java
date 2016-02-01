import java.util.Stack;

/**
 * LeetCode 331 - Verify Preorder Serialization of a Binary Tree
 *
 * Using a stack
 */
public class _331 {
    public boolean isValidSerialization(String preorder) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (String each : preorder.split(",")) {
            if (each.equals("#")) {
                stack.push(stack.pop() + 1);
            } else {
                if (!stack.empty()) stack.push(stack.pop() + 1);
                stack.push(0);
            }
            while (!stack.empty() && stack.peek() >= 2)
                if (stack.peek() == 2) stack.pop();
                else return false;
        }
        return stack.size() == 1 && stack.peek() == 1;
    }
}