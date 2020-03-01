"""1365. How Many Numbers Are Smaller Than the Current Number

Since each number is within the range [0, 100], we can use a counting sort based approach.
1. Do a linear-time counting.
2. Compute the prefix sum.
3. Answer each query in O(1) time.

Time: O(n)  
Space: O(100)
"""


class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        cnt = [0] * 101
        for i in nums:
            cnt[i] += 1
        for i in range(1, 101):
            cnt[i] += cnt[i - 1]
        return [cnt[i - 1] if i - 1 >= 0 else 0 for i in nums]
