"""
LeetCode 959 - Regions Cut By Slashes

Union-find-set
Break each cell into four triangular parts (up, down, left, right), then it is
immediately clear how to build the graph. And the problem simply boils down to
computing the # of connected components in the graph.
+-----+
|\ u /|
| \ / |
|l X r|
| / \ |
|/ d \|
+-----+
"""


class Solution:
    def regionsBySlashes(self, grid):
        """
        :type grid: List[str]
        :rtype: int
        """
        parent = dict()

        def find(i):
            if i not in parent:
                parent[i] = i
            if parent[i] != i:
                parent[i] = find(parent[i])
            return parent[i]

        def union(i, j):
            parent[find(i)] = find(j)

        n = len(grid)
        for i in range(n):
            for j in range(n):
                u, d, l, r = ((i, j, 'u'), (i, j, 'd'), (i, j, 'l'), (i, j, 'r'))
                if grid[i][j] == ' ':
                    union(u, d)
                    union(u, l)
                    union(u, r)
                elif grid[i][j] == '/':
                    union(u, l)
                    union(d, r)
                else:
                    union(u, r)
                    union(d, l)

                if j + 1 < n:
                    union(r, (i, j + 1, 'l'))
                if i + 1 < n:
                    union(d, (i + 1, j, 'u'))

        return len(set(find(i) for i in parent.keys()))
