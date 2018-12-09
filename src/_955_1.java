import java.util.stream.Stream;

public class _955_1 {


    public int minDeletionSize(String[] A) {
        int ans = 0;
        String[] s = Stream.of(A).map(i -> "").toArray(String[]::new);
        for (int j = 0; j < A[0].length(); j++) {
            boolean sorted = true;
            for (int i = 0; i < A.length - 1; i++) {
                String first = s[i] + A[i].charAt(j);
                String second = s[i + 1] + A[i + 1].charAt(j);
                int cmp = first.compareTo(second);
                if (cmp > 0) {
                    sorted = false;
                }
            }

            if (sorted) {
                for (int i = 0; i < A.length; i++) {
                    s[i] += A[i].charAt(j);
                }
            } else {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        _955_1 sol = new _955_1();
        System.out.println(sol.minDeletionSize(new String[]{"ca", "bb", "ac"}));
        System.out.println(sol.minDeletionSize(new String[]{"xc", "yb", "za"}));
        System.out.println(sol.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }
}

