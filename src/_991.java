/**
 * LeetCode 991 - Broken Calculator
 *
 * Math
 *
 * - If X >= Y, the answer is straightforwardly X - Y, as only subtraction here is meaningful.
 *
 * - If X < Y, we further consider two sub-cases.
 *
 *   (a) If Y % 2 == 1, then the last step has to be a subtraction, i.e.,
 *       X -> ... -> Y + 1 -> Y
 *
 *   (b) If Y % 2 == 0, then we argue that there exists some optimal solution in which the last step is a doubling, i.e.,
 *       X -> ... -> Y / 2 -> Y.
 *
 *       For a contradiction, assume the last step is a subtraction in ALL optimal solutions and Y is even, i.e.,
 *       X -> ... ->   Y + 1   ->    Y.
 *       Since Y + 1 is odd, according to (a), we have the second last step has to be a subtraction in all optimal solutions,
 *       X -> ... ->   Y + 2   ->   Y + 1   ->   Y.
 *
 *       For simplicity, assume the step to generate Y + 2 is a doubling.
 *       Then, X -> ... ->   Y/2 + 1   ->   Y + 2   ->   Y + 1   ->   Y.
 *       However, this is indeed not optimal as we could simplify the last three steps by two -- a subtraction followed by a doubling.
 *
 *       Note:
 *       In general, if there are at most 2K continuous subtractions at the end, i.e.,
 *       X -> ... (Y/2) + K   ->   Y + (2K)   ->   Y + (2K-1)   -> ... ->   Y + 2   ->   Y + 1   ->   Y,
 *       we can always shorten this "optimal" sequence by performing K subtraction first followed by a doubling,
 *       which is a contradiction.
 *
 * Now, every step is deterministic, and it is easy to see the runtime is O(log Y).
 */
public class _991 {

    public int brokenCalc(int X, int Y) {
        if (X >= Y) {
            return X - Y;
        } else if (Y % 2 == 1) {
            return brokenCalc(X, Y + 1) + 1;
        } else {
            return brokenCalc(X, Y / 2) + 1;
        }
    }
}

