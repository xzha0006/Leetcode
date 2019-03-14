class Solution {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10; 
            if (ans > (~(1 << 31) - Math.abs(digit))/ 10 || ans < ((1 << 31) + Math.abs(digit))/ 10) {
                return 0;
            }
            ans = ans * 10 + digit;
        }
        return ans;
    }
}
