"""1381. Design a Stack With Increment Operation

Maintain each prefix increment pointwisely and lazily.
Then all operations can be implemented in O(1) time.
"""

from collections import Counter

class CustomStack:

    def __init__(self, maxSize: int):
        self.inc = Counter() 
        self.s = []
        self.maxSize = maxSize

    def push(self, x: int) -> None:
        if len(self.s) < self.maxSize:
            self.s.append(x)

    def pop(self) -> int:
        if not self.s:
            return -1
        inc = self.inc[len(self.s)]
        x = self.s[-1]
        self.inc[len(self.s) - 1] += self.inc[len(self.s)]
        self.inc[len(self.s)] = 0
        self.s.pop()
        return x + inc

    def increment(self, k: int, val: int) -> None:
        self.inc[min(k, len(self.s))] += val
