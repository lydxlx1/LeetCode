"""
Alphabet Board Path
"""


class Solution:
    def alphabetBoardPath(self, target: str) -> str:
        board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]
        pos = {}
        for i in range(len(board)):
            for j in range(len(board[i])):
                pos[board[i][j]] = (i, j)
        board_indices = set(pos.values())
        dir = {(-1, 0): "U", (1, 0): "D", (0, 1): "R", (0, -1): "L"}

        x, y = 0, 0
        ans = ""
        for ch in target:
            xx, yy = pos[ch]
            while not (x == xx and y == yy):
                dx, dy = xx - x, yy - y
                # Convert into a unit dir vector.
                # max(., 1) to avoid division by zero
                dx, dy = dx // max(abs(dx), 1), dy // max(abs(dy), 1)
                # When it's okay to move via both directions, choose the one that we will still be on the board.
                if abs(dx) == 1 and abs(dy) == 1:
                    if (x, y + dy) in board_indices:
                        dx = 0
                    else:
                        dy = 0
                ans += dir[dx, dy]
                x, y = x + dx, y + dy
            ans += "!"

        return ans
