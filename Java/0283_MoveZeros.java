class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) continue;
            int tmp = nums[j + 1];
            nums[j + 1] = nums[i];
            nums[i] = tmp;
            ++j;
        }
    }
}
