/**
 * LeetCode 640 - Solve the Equation
 * <p>
 * Pay extreme attention to the following:
 * <p>
 * 0x = 0
 * 1+x = 3
 * 1-x = 4
 * 3 = 3
 */
public class _640 {
    public String solveEquation(String equation) {
        int index = equation.indexOf('=');
        long[] left = parse(equation.substring(0, index));
        long[] right = parse(equation.substring(index + 1));
        left[0] -= right[0];
        left[1] -= right[1];

        if (left[0] == 0) {
            if (left[1] == 0) return "Infinite solutions";
            else return "No solution";
        } else {
            return String.format("x=%d", -left[1] / left[0]);
        }
    }

    private long[] parse(String exp) {
        long[] res = {0, 0};
        for (int i = 0; i < exp.length(); ) {
            long val = 0;
            long sign = 1;
            if (exp.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (exp.charAt(i) == '+') {
                sign = 1;
                i++;
            }

            while (i < exp.length() && Character.isDigit(exp.charAt(i)))
                val = val * 10 + exp.charAt(i++) - '0';

            if (i < exp.length() && exp.charAt(i) == 'x') {
                if (val == 0) {
                    if (i - 1 >= 0 && exp.charAt(i - 1) == '0')
                        res[0] += 0; // 0x
                    else
                        res[0] += 1 * sign;
                } else {
                    res[0] += sign * val;
                }
                i++; // skip 'x'
            } else {
                res[1] += sign * val;
            }
        }
        return res;
    }
}