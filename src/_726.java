import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * LeetCode 726 - Number of Atoms
 * <p>
 * LL-Parser
 * Rules:
 * 1) S -> epsilon, triggered when the next character is epsilon or ')'.
 * 2) S -> [A-Z][a-z]*[0-9]* S, triggered when the next character is [A-Z].
 * 3) S -> (S)[0-9]* S, triggered when the next character is '('.
 */
class _726 {
    int ptr = 0;
    String s;

    public String countOfAtoms(String formula) {
        ptr = 0;
        s = formula;
        Map<String, Integer> map = doit();
        return String.join("", map.keySet().stream().sorted().map(k -> k + (map.get(k) == 1 ? "" : "" + map.get(k))).collect(Collectors.toList()));
    }

    private Map<String, Integer> doit() {
        if (ptr >= s.length() || s.charAt(ptr) == ')')
            return new HashMap<>();
        else {
            Map<String, Integer> m;
            if (s.charAt(ptr) == '(') {
                ptr++; // eat '('
                m = doit();
                ptr++; // eat ')'
                int count = count();
                m.replaceAll((k, v) -> v * count);  // v * count() is wrong since this lambda will be applied to all the keys but count() can only be called once here.
            } else {
                m = new HashMap<>();
                m.put(atom(), count());
            }
            return merge(m, doit());
        }
    }

    private Map<String, Integer> merge(Map<String, Integer> m, Map<String, Integer> M) {
        if (m.size() > M.size()) return merge(M, m);
        for (String atom : m.keySet())
            M.put(atom, M.getOrDefault(atom, 0) + m.get(atom));
        return M;
    }

    private String atom() {
        String res = "" + s.charAt(ptr++);
        for (; ptr < s.length() && Character.isLowerCase(s.charAt(ptr)); ptr++)
            res += s.charAt(ptr);
        return res;
    }

    private int count() {
        String res = "";
        for (; ptr < s.length() && Character.isDigit(s.charAt(ptr)); ptr++)
            res += s.charAt(ptr);
        return res.isEmpty() ? 1 : Integer.parseInt(res);
    }

    public static void main(String[] args) {
        _726 sol = new _726();
        System.out.println(sol.countOfAtoms("Mg(OH)2"));
    }
}