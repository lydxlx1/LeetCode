/**
 * Parsing A Boolean Expression
 *
 * Parser
 * DFS approach
 */
public class ParsingABooleanExpression {

    int ptr = 0;
    String s;

    public boolean parseBoolExpr(String expression) {
        s = expression;
        ptr = 0;
        return dfs();
    }

    char peek() {
        return s.charAt(ptr);
    }

    char next() {
        return s.charAt(ptr++);
    }

    boolean dfs() {
        boolean res;
        char ch = next();
        if (ch == 't') {
            res = true;
        } else if (ch == 'f') {
            res = false;
        } else if (ch == '!') {
            assert (next() == '(');
            res = !dfs();
            assert (next() == ')');
        } else {
            res = ch == '&' ? true : false;
            assert (next() == '(');
            while (true) {
                // WARNING: It is wrong to write "res = res && dfs()" as Java might decided not to call dfs() when
                // res is already equal to false due to short circuit property, which will cause failure in parsing
                // the entire string.
                // The similar logic applies to || case.
                if (ch == '&') {
                    res = dfs() && res;
                } else {
                    res = dfs() || res;
                }

                assert (peek() == ')' || peek() == ',');
                if (next() == ')') {
                    break;
                }
            }
        }
        return res;
    }
}
