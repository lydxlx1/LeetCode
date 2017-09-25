import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 682 - Baseball Game
 * <p>
 * Implementation
 */
class _682 {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        for (String op : ops) {
            if (op.charAt(0) == 'D') {
                list.add(list.get(list.size() - 1) * 2);
            } else if (op.charAt(0) == 'C') {
                list.remove(list.size() - 1);
            } else if (op.charAt(0) == '+') {
                list.add(list.get(list.size() - 2) + list.get(list.size() - 1));
            } else {
                list.add(Integer.parseInt(op));
            }

        }
        return list.stream().mapToInt(i -> i).sum();
    }

    public static void main(String[] args) {
        _682 sol = new _682();
        System.out.println(sol.calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(sol.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }
}
