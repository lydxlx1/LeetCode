"""152. Maximum Product Subarray"""

import functools


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        """First attempt, which is complicated but marks how I started to tackle this problem.

        1. If the array contains only one element, then that's the answer.
        2. If the array contains zeros, then answer is at least zero. In addition, any subarray that contains a zero
           will result in a zero product. Therefore, we can split the array by zero and obtain a list of subarrays
           that do not contain any zero. Then, we can recursively solve these subproblems and take their max products
           and max with the zero product we initially get.
        3. Now, it suffices to assume that all elements in nums are integers with absolute value greater than 0. We
           then have two cases.
        3a. If there are even number of negative integers, then it is clear that the total array product will be
            positive and will be the largest one.
        3b. If there are odd number of negative integers and let's assume that the first and last negative integers
            appear at index a and b, then the largest product must be either (nums[a + 1] * nums[a + 1] * ... * nums[n - 1])
            or (nums[0] * nums[1] * ... * nums[b - 1]).

            For convenience, instead of doing exactly what the above algorithm suggests, it suffices to comptue all the
            prefix and suffix products and take the max. (This also covers 3a.)

        Time: O(n)
        Space: O(n)
        """
        if len(nums) == 1:
            return nums[0]
        if 0 in nums:
            ans = 0
            cand = []
            for i in nums:
                if i != 0:
                    cand.append(i)
                else:
                    if cand:
                        ans = max(ans, self.maxProduct(cand))
                    cand = []
            if cand:
                ans = max(ans, self.maxProduct(cand))
            return ans
        else:
            ans = nums[0]
            prefix = 1
            for i in nums:
                prefix *= i
                ans = max(ans, prefix)
            suffix = 1
            for i in reversed(nums):
                suffix *= i
                ans = max(ans, suffix)
            return ans


    def maxProduct(self, nums: List[int]) -> int:
        """Second attempt

        1. Initialize ans to be max(nums), which covers case 1 and the zero case of case 2.
        2. Do a global prefix and suffix product but restart the accumulating when encountering any zeros.
           This will cover the remaining part of case 2 and case 3.

        Time: O(n)
        Space: O(1)
        """
        ans = max(nums)
        prefix = 1
        for i in nums:
            if i:
                prefix *= i
                ans = max(ans, prefix)
            else:
                prefix = 1
        suffix = 1
        for i in reversed(nums):
            if i:
                suffix *= i
                ans = max(ans, suffix)
            else:
                suffix = 1
        return ans

    def maxProduct(self, nums: List[int]) -> int:
        """Third attempt

        Further simplify the code... But will use O(n) extra space.

        Time: O(n)
        Space: O(n)
        """
        A, B = nums, nums[::-1]
        for i in range(1, len(A)):
            A[i] *= A[i - 1] or 1
            B[i] *= B[i - 1] or 1
        return max(A + B)
