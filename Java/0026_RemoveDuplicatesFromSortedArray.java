class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) {
                
            } else {
                nums[++left] = nums[i];
            } 
        }
        return left + 1;
    }
}
