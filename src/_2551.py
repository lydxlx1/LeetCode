"""
LeetCode 2551 - Put Marbles in Bags

Sorting

Thinking about the following example, where k = 4.

[1, 3][4, 2, 8][4][3, 3]

The cost is 1 + (3 + 4) + (8 + 4) + (4 + 3) + 3,
where
(1) weights[0] and weights[-1] will always be there
(2) the rest sum is equal to sum of neighbors of all the cut points.

It is clear to see a one-to-one correspondence here. Therefore,
we just need to constructure another array,
[ weights[0] + weights[1], weights[1] + weights[2], ..., weights[n-2] + weights[n-1]],
of length n - 1.

And then find the smallest / largest k - 1 elements from it.

Time complexity: O(n log n)
Space complexity: O(n)

Note that, it's also possible to further optimize the runtime to O(n) by using
linear-time selection algorithm, but it's not necessary in practice.
"""
class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        if k == 1:
            return 0
        pairs = []
        for i in range(1, len(weights)):
            pairs.append(weights[i] + weights[i - 1])
        pairs.sort()
        m = sum(pairs[:k - 1])
        M = sum(pairs[-(k-1):])
        return M - m

