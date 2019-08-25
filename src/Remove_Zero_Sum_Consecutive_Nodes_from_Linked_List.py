"""
Remove Zero Sum Consecutive Nodes from Linked List

Prefix Sum
"""

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def removeZeroSumSublists(self, head: ListNode) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head
        map = {0: dummy}
        sum = 0

        i = dummy
        while i.next:
            i = i.next

            sum += i.val
            if sum in map:
                map[sum].next = i.next
            else:
                map[sum] = i

        return dummy.next

