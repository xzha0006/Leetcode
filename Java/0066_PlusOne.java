class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0, i, tmp;
        int n = digits.length;
        for (i = n - 1; i >= 0; i--) {
            tmp = digits[i] + (i == n - 1 ? 1 : carry);
            carry = tmp / 10;
            digits[i] = tmp % 10;
        }
        //key point: result may have one digit more than origin array.
        if (carry == 1) {
            digits = new int[n+1];
            digits[0] = 1;
        }
        return digits;
    }
}
