"""
LeetCode 752 - Open the Lock

BFS
"""
from collections import deque


class Solution:
    def _gen_next(self, lock):
        for i in range(len(lock)):
            ch = lock[i]

            lock[i] = '0' if ch == '9' else chr(ord(ch) + 1)
            yield ''.join(lock)

            lock[i] = '9' if ch == '0' else chr(ord(ch) - 1)
            yield ''.join(lock)

            lock[i] = ch

    def openLock(self, dead_ends, target):
        """
        :type deadends: List[str]
        :type target: str
        :rtype: int
        """
        dead_ends = set(dead_ends)
        if target == '0000':
            return 0
        if target in dead_ends or '0000' in dead_ends:
            return -1

        dist = {}
        dist['0000'] = 0
        queue = deque()
        queue.append('0000')

        while queue:
            lock = queue.popleft()
            if lock == target:
                return dist[lock]

            for next_lock in self._gen_next(list(lock)):
                if next_lock not in dead_ends and next_lock not in dist.keys():
                    dist[next_lock] = dist[lock] + 1
                    queue.append(next_lock)

        return -1
