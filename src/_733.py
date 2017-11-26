"""
LeetCode 733 - Flood Fill

DFS solution
Be careful when old_color == new_color.
"""
class Solution:
    def floodFill(self, image, sr, sc, new_color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type newColor: int
        :rtype: List[List[int]]
        """

        dx = (0, 0, 1, -1)
        dy = (1, -1, 0, 0)
        old_color = image[sr][sc]

        if old_color == new_color:
            return image

        def dfs(i, j):
            image[i][j] = new_color
            for k in range(4):
                x, y = i + dx[k], j + dy[k]
                if x >= 0 and x < len(image) and y >= 0 and y < len(image[0]) and image[x][y] == old_color:
                    dfs(x, y)

        dfs(sr, sc)
        return image
