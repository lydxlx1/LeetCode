import java.util.stream.IntStream;


/**
 * LeetCode 905 - Sort Array By Parity
 *
 * 1-Liner
 */
public class _905 {

    public int[] sortArrayByParity(int[] A) {
        return IntStream.concat(IntStream.of(A).filter(i -> i % 2 == 0), IntStream.of(A).filter(i -> i % 2 != 0)).toArray();
    }
}

