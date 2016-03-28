/*
LeetCode 218 - The Skyline Problem

O(n log n) sweepline algorithm
The sweepline algorithm itself is pretty short and elegant. (10-line code)
However, the pre-sorting needs significant attentions when tie appears, i.e.,
when two endpoints are sharing the same x-coordinate. We need to obey exactly the rules below.

1. Endpoints of left boundaries come before endpoints of right boundaries.
2. Among left endpoints that sharing the same x-coordinate, higher endpoints appear before lower endpoints.
3. Among right endpoints that sharing the same x-coordinate, lower endpoints appear before higher endpoints.



Some "nasty" examples.

+---+----+
|   |    |
|   |    |
+---+----+


+--------+
|        |
+-----+  |
|     |  |
+--+  |  |
|  |  |  |
+--+--+--+


+--------+
|        |
+--------+
|        |
+--------+
|        |
+--------+
*/
class Solution {
public:
    vector<pair<int, int>> getSkyline(vector<vector<int>>& buildings) {
        vector<pair<int, int>> coord;
        for (int i=0; i < buildings.size(); i++) {
            coord.push_back(make_pair(i, 0));
            coord.push_back(make_pair(i, 1));
        }
        sort(coord.begin(), coord.end(), [&buildings](pair<int, int> a, pair<int, int> b) {
            if (buildings[a.first][a.second] == buildings[b.first][b.second])
                if (a.second != b.second) return a.second < b.second;
                else if (a.second == 0) return buildings[a.first][2] > buildings[b.first][2];
                else return buildings[a.first][2] < buildings[b.first][2];
            else return buildings[a.first][a.second] < buildings[b.first][b.second];
        });

        multiset<int> set;
        set.insert(0);
        vector<pair<int, int>> ans;
        for (auto pair : coord) {
            int oldMax = *set.rbegin();
            if (pair.second == 0) set.insert(buildings[pair.first][2]);
            else set.erase(set.find(buildings[pair.first][2]));
            if (oldMax != *set.rbegin()) ans.push_back(make_pair(buildings[pair.first][pair.second], *set.rbegin()));
        }
        return ans;
    }
};
