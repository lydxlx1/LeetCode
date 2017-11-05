"""
LeetCode 723 - Candy Crush

Simulation Problem
Note that, it is not finding connected components of size >= 3.
It just finds horizontal or vertical connected strips of size >= 3.
"""


class Solution:
    def candyCrush(self, board):
        """
        :type board: List[List[int]]
        :rtype: List[List[int]]
        """
        r, c = (len(board), len(board[0]))

        def drop(board):
            changed = False
            for j in range(c):
                len = r
                for i in reversed(range(r)):
                    if board[i][j] != 0:
                        board[len - 1][j] = board[i][j]
                        len -= 1
                for i in range(len):
                    board[i][j] = 0
            return changed

        clear = []
        for i in range(r):
            j = 0
            while j < c:
                jj = j
                while jj < c and board[i][j] == board[i][jj]:
                    jj += 1
                if jj - j >= 3 and board[i][j] != 0:
                    clear += [(i, k) for k in range(j, jj)]
                j = jj
        for j in range(c):
            i = 0
            while i < r:
                ii = i
                while ii < r and board[i][j] == board[ii][j]:
                    ii += 1
                if ii - i >= 3 and board[i][j] != 0:
                    clear += [(k, j) for k in range(i, ii)]
                i = ii
        for (i, j) in clear:
            board[i][j] = 0

        drop(board)
        return self.candyCrush(board) if clear else board

