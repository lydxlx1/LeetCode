"""Maximum Number of Events That Can Be Attended

Greedy + Heap / BST

Sweep time stamp t for 0 to 10**5, for each t, we would like to
(i) identify all the events whose interval contain t, and 
(ii) attend the event with earliest ending time if any.

(ii) is the greedy step. For correctness:
First, one needs to show it cannot be worse to take an event at t if there's any candidate.
Second, one needs to prove it cannot be worse to take the event with earliest end time among all the feasible candidates.

For implementation:
(i) can be done efficiently via a global sorting on event's start time.
(ii) can be maintained using a heap or balanced BST.

"""

from sortedcontainers import SortedList


class Solution:
    def maxEvents(self, events: List[List[int]]) -> int:
        events = sorted(events)
        ans = 0
        i = 0
        cand = SortedList()
        for t in range(1, 10 ** 5 + 1):
            while i < len(events) and events[i][0] <= t:
                cand.add(events[i][1])
                i += 1
            while cand and cand[0] < t:
                cand.remove(cand[0])
            if cand:
                ans += 1
                cand.remove(cand[0])
        return ans
