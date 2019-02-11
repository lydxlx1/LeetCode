/**
 * LeetCode 990 - Satisfiability of equality equations
 *
 * Union-Find Set
 */
public class _990 {

    char[] parent;

    char find(char i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    void union(char i, char j) {
        parent[find(i)] = find(j);
    }

    public boolean equationsPossible(String[] equations) {
        parent = new char[128];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = (char) i;
        }

        for (String equation : equations) {
            if (equation.indexOf("==") >= 0) {
                union(equation.charAt(0), equation.charAt(3));
            }
        }
        for (String equation : equations) {
            if (equation.indexOf("!=") >= 0) {
                char a = equation.charAt(0);
                char b = equation.charAt(3);
                if (find(a) == find(b)) {
                    return false;
                }
            }
        }
        return true;
    }
}

