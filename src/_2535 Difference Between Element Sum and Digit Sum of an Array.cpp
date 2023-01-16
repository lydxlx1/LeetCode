/**
 * LeetCode 2535 - Difference Between Element Sum and Digit Sum of an Array
 */
class Solution {
public:
  int differenceOfSum(vector<int> &nums) {
    int element_sum = 0, digit_sum = 0;
    for (int num: nums) {
      element_sum += num;
      while (num) {
        digit_sum += num % 10;
        num /= 10;
      }
    }
    return abs(element_sum - digit_sum);
  }
};
