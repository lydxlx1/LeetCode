import java.util.Arrays;

/**
 * LeetCode 838 - Push Dominoes
 */
public class _838 {

    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R";
        char[] a = dominoes.toCharArray();

        // This changes "R...R" to "RRRR" and changes "L...L" to "LLLL".
        for (int i = 0, j; i < a.length; i++)
            if (a[i] == 'L' || a[i] == 'R') {
                for (j = i + 1; j < a.length && a[j] == '.'; j++) ;
                if (j < a.length && a[j] == a[i])
                    Arrays.fill(a, i, j, a[i]);
            }

        // Then, handle the case for "R....L" separately.
        for (int i = 0, j = 0; i < a.length; )
            if (a[i] == 'R') {
                for (j = i + 1; j < a.length && a[j] == '.'; j++) ;

                if (j < a.length && a[j] == 'L') {
                    for (int begin = i, end = j; begin < end; begin++, end--) {
                        a[begin] = 'R';
                        a[end] = 'L';
                    }
                }
                i = j;
            } else {
                i++;
            }

        String str = String.valueOf(a);
        return str.substring(1, str.length() - 1);
    }

    public static void main(String[] args) {
        _838 sol = new _838();
        System.out.println(sol.pushDominoes(".L.R...LR..L.."));
        System.out.println(sol.pushDominoes("RR.L"));
    }
}

