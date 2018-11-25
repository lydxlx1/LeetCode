from collections import defaultdict

"""
LeetCode 947 - Most Stones Removed with Same Row or Column

Treat every stone as a vertex in the graph.
Then there is an undirected edge connecting two (different) stones if and only if they are at the same row or column.
Now for each connected component of the graph, if it component contains K vertices, we can always remove at most
K - 1 vertices from it while keeping the remaining component connected. Why? In the worst case, this connected component
is a tree, and in this case if we always remove the leaf node (i.e., the node of degree one), the tree will always
remain connected.

Then, the final answer is equal to (total # of vertices in the graph) - (# of connected components).
"""
class Solution:
    def removeStones(self, stones):
        """
        :type stones: List[List[int]]
        :rtype: int
        """
        
        parents = {(x, y) : (x, y) for (x, y) in stones}
        
        def find(i):
            if parents[i] != i:
                parents[i] = find(parents[i])
            return parents[i]
        
        def union(i, j):
            parents[find(i)] = find(j)
        
        map_x = defaultdict(list)
        map_y = defaultdict(list)
        for (x, y) in stones:
            map_x[x].append((x, y))
            map_y[y].append((x, y))

        for x in map_x.keys():
            for stone in map_x[x]:
                union(map_x[x][0], stone)
        for y in map_y.keys():
            for stone in map_y[y]:
                union(map_y[y][0], stone)
        
        return len(stones) - len({ find(stone) for stone in parents })
        