/**
 * LeetCode 439 - Ternary Expression Parser
 * <p>
 * Top-down approach
 */
public class _439 {

    int ptr;
    String exp;

    private char dfs() {
        char val = exp.charAt(ptr++);
        if (ptr >= exp.length() || exp.charAt(ptr) != '?') return val;

        ptr++; // skip ?
        char trueClause = dfs();
        ptr++; // skip :
        char falseCluse = dfs();
        return val == 'T' ? trueClause : falseCluse;
    }

    public String parseTernary(String expression) {
        exp = expression;
        ptr = 0;
        return "" + dfs();
    }
}