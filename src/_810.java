/**
 * LeetCode 810 - Chalkboard XOR Game
 *
 * Game theory
 *
 * Given an array, A[1..n], of n non-negative integers, where xor(A[i]) != 0.
 * Then Alice loses the game if and only if n is odd.
 *
 * Proof:
 * The statement is clearly true when n = 1.
 *
 * When n > 1, let Alice make any VALID move, say A[1]. Valid move here means xor(A[2], A[3], ..., A[n]) != 0.
 * We now assert that Bob can always pick a number (say A[2]) such that xor(A[3], ..., A[n]) != 0, and then by induction,
 * Alice will lose.
 *
 * The question left is why such a move always exists for Bob?
 * For a contradiction, if the move does not exist, then we have
 *
 * (A[2] xor A[3] xor ... xor A[n]) xor A[2] = 0,
 * (A[2] xor A[3] xor ... xor A[n]) xor A[3] = 0,
 * ...
 * (A[2] xor A[3] xor ... xor A[n]) xor A[n] = 0.
 *
 * A total of (n - 1) equations. Note that here (n - 1) is even.
 *
 * If we xor all these (n - 1) equations together, we simply have
 * A[2] xor A[3] xor ... xor A[n] = 0,
 * which contradicts to our previous assumption that Alice's move is valid.
 */
public class _810 {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0 || nums.length % 2 == 0;
    }
}
