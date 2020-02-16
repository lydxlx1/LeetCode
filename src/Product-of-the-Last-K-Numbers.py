"""Product of the Last K Numbers

Compact array

Pay attention to the following statement
> At any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.

This means the following:
- The answer is 0 if there is at least a zero for the k numbers.
- If there's no zero, the # of distinct numbers that are greater than 1 cannot be more than log_2(k) < 32.

Therefore, we can store the numbers in a compacted manner and then compute the product by brute-force."""


class ProductOfNumbers:
    def __init__(self):
        self.a = []

    def add(self, num: int) -> None:
        if not self.a or self.a[-1][0] != num:
            self.a.append([num, 1])
        else:
            self.a[-1][1] += 1

    def getProduct(self, k: int) -> int:
        prod = 1
        ptr = -1
        while prod > 0 and k > 0:
            prod *= self.a[ptr][0] ** min(self.a[ptr][1], k)
            k -= self.a[ptr][1]
            ptr -= 1
        return prod


# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)
