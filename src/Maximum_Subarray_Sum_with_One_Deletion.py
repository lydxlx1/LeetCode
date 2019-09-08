"""Maximum Subarray Sum with One Deletion

DP
Time = O(n)
Space = O(1)
"""

from typing import *


class Solution:
    def maximumSum(self, arr: List[int]) -> int:
        inf = 1 << 31
        delete_0 = arr[0]
        delete_1 = -inf
        ans = delete_0

        for i in range(1, len(arr)):
            new_delete_0 = max(delete_0 + arr[i], arr[i])
            new_delete_1 = max(delete_0, delete_1 + arr[i])
            delete_0, delete_1 = new_delete_0, new_delete_1
            ans = max(ans, delete_0, delete_1)

        return ans
