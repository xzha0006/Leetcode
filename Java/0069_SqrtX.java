class Solution {
    public int mySqrt(int x) {
        if (x == 1) return 1;
        int left = 1, right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            int power = mid * mid;
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left - 1;
    }
}
