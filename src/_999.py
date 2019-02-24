"""
LeetCode 999 - Available Captures for Rook
"""
from typing import *


class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        cnt = 0

        for i in range(8):
            for j in range(8):
                if board[i][j] == 'R':
                    for k in range(4):
                        x, y = i + dx[k], j + dy[k]
                        while 0 <= x < 8 and 0 <= y < 8:
                            if board[x][y] != '.':
                                cnt += 1 if board[x][y] == 'p' else 0
                                break
                            x += dx[k]
                            y += dy[k]

        return cnt
