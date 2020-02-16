"""Construct Target Array With Multiple Sums

Backtracking

Find the largest number in the array, there's a unique way to compute its value in the previous stage.
Keep doing so until
(i) all numbers are equal to 1 --> True
(ii) any number becomes negative --> False

Use a SortedList for O(log n) accessing.

Time: O(n log n)
Space: O(n)
"""

from sortedcontainers import SortedList


class Solution:
    def isPossible(self, target: List[int]) -> bool:
        a = SortedList(target)
        s = sum(a)
        while True:
            if a[0] < 0:
                return False
            if a[-1] == 1:
                return True

            after = a[-1]
            before = after - (s - after)
            s = s - after + before
            a.remove(after)
            a.add(before)
        return True
