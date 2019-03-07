class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int j = n - 1, i;
        for (i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                break;
            }
        }
        if (i >= 0) {
            for (j = n - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    break;
                }
            }
        }
        if (i >= 0) swap(nums, i, j);
        reverse(nums, i + 1, n - 1);
    }
    
    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
