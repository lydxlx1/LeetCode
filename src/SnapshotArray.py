"""
Snapshot Array

Binary Search
"""


class SnapshotArray:

    def __init__(self, length: int):
        self.arr = [[[0, 0].copy()].copy() for i in range(length)]
        self.m = 0

    def set(self, index: int, val: int) -> None:
        if self.arr[index][-1][0] < self.m:
            self.arr[index].append([self.m, val])
        else:
            assert self.arr[index][-1][0] == self.m
            self.arr[index][-1][1] = val

    def snap(self) -> int:
        self.m += 1
        return self.m - 1

    def get(self, index: int, snap_id: int) -> int:
        if not self.arr[index]:
            return 0
        elif self.arr[index][-1][0] <= snap_id:
            return self.arr[index][-1][1]
        else:
            left = 0
            right = len(self.arr[index]) - 1
            while left + 1 < right:
                assert self.arr[index][left][0] <= snap_id < self.arr[index][right][0]  # invariant
                mid = (left + right) // 2
                if self.arr[index][mid][0] <= snap_id:
                    left = mid
                else:
                    right = mid
            return self.arr[index][left][1]

# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)
