import java.util.Stack;

/**
 * LeetCode 1006 - Clumsy Factorial
 *
 * Stack
 */
public class _1006 {

    public int clumsy(int N) {
        char[] ops = {'*', '/', '+', '-'};
        int k = 0;
        Stack<Integer> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        s1.push(N);

        for (int i = N - 1; i >= 1; i--, k = (k + 1) % 4) {
            char op = ops[k];
            if (s2.isEmpty()) {
                s1.push(i);
                s2.push(op);
            } else {
                if (op == '+' || op == '-') {
                    while (!s2.isEmpty()) {
                        calc(s1, s2);
                    }
                } else {
                    while (!s2.isEmpty() && (s2.peek() == '*' || s2.peek() == '/')) {
                        calc(s1, s2);
                    }
                }
                s1.add(i);
                s2.add(op);
            }
        }
        while (!s2.isEmpty()) {
            calc(s1, s2);
        }
        return s1.pop();
    }

    void calc(Stack<Integer> s1, Stack<Character> s2) {
        int b = s1.pop();
        int a = s1.pop();
        char op = s2.pop();
        if (op == '+') {
            s1.push(a + b);
        } else if (op == '-') {
            s1.push(a - b);
        } else if (op == '*') {
            s1.push(a * b);
        } else {
            s1.push(a / b);
        }
    }
}

