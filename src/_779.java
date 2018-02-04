/**
 * LeetCode 779 - K-th Symbol in Grammar
 * <p>
 * Recursion
 */
public class _779 {


    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        } else {
            return kthGrammar(N - 1, (K + 1) / 2) ^ ((K + 1) % 2);
        }
    }

    public static void main(String[] args) {
        _779 sol = new _779();

        for (int N = 1; N <= 5; N++) {
            for (int j = 1; j <= (1 << (N - 1)); j++) {
                System.out.print(sol.kthGrammar(N, j));
            }
            System.out.println();
        }
        System.out.println(sol.kthGrammar(30, 1 << 29));
    }
}



