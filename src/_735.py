"""
LeetCode 735 - Asteroid Collision

Use a stack
"""
class Solution:
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        res, stack = [], []
        for size in asteroids:
            if size > 0:
                stack.append(size)
            else:
                while stack and abs(size) > stack[-1]:
                    stack.pop()

                if stack:
                    if stack[-1] == abs(size):
                        stack.pop()  # Equal size and thus cancel each other.
                else:
                    res.append(size)
        return res + stack
