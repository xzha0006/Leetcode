class Solution {
    public int climbStairs(int n) {
        int sum = 1, i = 1, prev = 1;
        while (i < n) {
            int tmp = sum;
            sum += prev;
            prev = tmp;
            ++i;
        }
        return sum;
    }
}
