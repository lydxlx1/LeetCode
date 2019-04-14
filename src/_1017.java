/**
 * LeetCode 1017 - Convert to Base -2
 *
 * Math
 * Be careful when N == 0
 */
public class _1017 {

    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        int cnt = 0;
        while (N != 0) {
            if (N % 2 == 0) {
                builder.append(0);
            } else {
                builder.append(1);
                N += cnt % 2 == 0 ? (-1) : 1;
            }
            N /= 2;
            cnt++;
        }
        return builder.reverse().toString();
    }
}

