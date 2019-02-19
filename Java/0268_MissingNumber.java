class Solution {
    public int missingNumber(int[] nums) {
        int i, sum = 0;
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return nums.length * (nums.length + 1) / 2 - sum; // gaussian sum
    }
}
