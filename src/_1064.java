/**
 * LeetCode 1064 - Fixed Point
 */
public class _1064 {

    public int fixedPoint(int[] A) {
        for (int i=0; i<A.length; i++) {
            if (A[i] == i) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        _1064 sol = new _1064();

    }
}
