/**
 * Find in Mountain Array
 *
 * Binary search
 * Use one binary search to find the peak.
 * Then we can do two binary search to obtain the answer.
 */
public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int begin = 0, end = n - 1;
        while (begin < end) {
            int mid = (begin + end) / 2; // Lower median obtained
            // Notice that we'll always shrink the window by at least one
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        int peak = begin;
        if (mountainArr.get(peak) == target) {
            return peak;
        } else {
            int ans = Math.min(binarySearch(target, 0, peak - 1, mountainArr, true), binarySearch(target, peak + 1, n - 1, mountainArr, false));
            return (ans < (1 << 29) ? ans : -1);
        }
    }

    int binarySearch(int target, int begin, int end, MountainArray arr, boolean increasing) {
        while (begin <= end) {
            int mid = (begin + end) / 2;
            int val = arr.get(mid);
            if (val == target) {
                return mid;
            } else if ((val > target) ^ !increasing) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return 1 << 29;
    }
}
