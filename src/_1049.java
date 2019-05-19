import java.util.stream.IntStream;

/**
 * LeetCode 1049 - Last Stone Weight II
 *
 * Knapsack
 * This problem is equivalent to find a subset of stones with sum closest to half of the total sum.
 *
 * Thinking this problem in terms of the following way:
 * 1. The entire merging process can be expressed using a FULL binary tree, where the root is the "minus"
 *    operator and is computing the subtraction of right subtree from left subtree.
 *
 *    For instance, taking the following tree as an example.
 *        -
 *       / \
 *      A  -
 *        / \
 *       _   B
 *      / \
 *     C   D
 *
 *    This indicated
 *    (a) C - D
 *    (b) (C - D) - B
 *    (c) A - [(C - D) - B]
 *    which can be expanded as A - C + D + B, which partitions A, B, D as a group and C as the other group.
 *
 * 2. The second question is given an arbitrary partition can we always construct a tree corresponding to it?
 *    The answer is YES, and we can do this by a greedy contruction approach. I will explain this via an example.
 *
 *    Say (A, B, C, D, E) as the positive group, and (F, G) as the negative group.
 *
 *    We construct the tree in a top-down manner, and prefer to create a leaf w.r.t. the larger group.
 *
 *    Step 1:
 *    +: A, B, C, D, E
 *    -: F, G
 *
 *    Positive group is bigger, so I will make a leaf to A.
 *      -
 *     / \
 *    A   ?
 *
 *    Now, my positive group becomes [B, C, D, E], and my negative group is still [F, G].
 *    However, when we recursively construct the tree ?, we need to SWAP both groups as ? is on the negative
 *    branch, i.e., in next round, my positive group is indeed [F, G] and negative group becomes [B, C, D, E].
 *
 *
 *    Step 2:
 *    +: F, G
 *    -: B, C, D, E
 *
 *    Negative group is larger, so let us make a leaf for (say) B.
 *      -
 *     / \
 *    A   _
 *       / \
 *      ?   B
 *
 *    This time ? is on the left branch, so we don't need to swap two groups.
 *
 *
 *    Step 3:
 *    +: F, G
 *    -: C, D, E
 *
 *    Negative group is still larger, so we make a leaf for (say) C.
 *      -
 *     / \
 *    A   _
 *       / \
 *      -   B
 *     / \
 *    ?   C
 *
 *
 *    Step 4:
 *    +: F, G
 *    -: D, E
 *
 *    Now we have a tie, we can go either way. Say we want to handle F in the positive group.
 *          -
 *         / \
 *        A   _
 *           / \
 *          -   B
 *         / \
 *        -   C
 *       / \
 *      F   ?
 *
 *    Before we advance to next round, remember to remove F from positive group and swap two groups!
 *
 *
 *    Step 5:
 *    +: D, E
 *    -: G
 *
 *    Positive group is larger, say we pick D.
 *          -
 *         / \
 *        A   _
 *           / \
 *          -   B
 *         / \
 *        -   C
 *       / \
 *      F   _
 *         / \
 *        D   ?
 *
 *    (Don't forget to swap the groups again!)
 *
 *
 *    Step 6:
 *    +: G
 *    -: E
 *
 *    As two groups both have only one element left, we can now make a terminating step.
 *
 *          -
 *         / \
 *        A   _
 *           / \
 *          -   B
 *         / \
 *        -   C
 *       / \
 *      F   _
 *         / \
 *        D   -
 *           / \
 *          G   E
 *
 *    As two groups both have only one element left, we can now make a terminating step.
 *
 *
 *    We are DONE!
 *    One can try to expand the tree and verify this indeed matches the given partition.
 */
public class _1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = IntStream.of(stones).sum();
        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        int ans = sum;
        for (int stone : stones) {
            for (int j = sum; j - stone >= 0; j--) {
                f[j] = f[j] || f[j - stone];
                if (f[j]) {
                    ans = Math.min(ans, Math.abs(j - (sum - j)));
                }
            }
        }
        return ans;
    }
}
