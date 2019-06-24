class Solution {
    public int search(int[] nums, int target) {
        return bsHelper(0, nums.length-1, nums, target);
    }
    
    private int bsHelper(int left, int right, int[] nums, int target) {
        int midIndex = (right+left)/2;
        int mid = nums[midIndex];
        //does not exist
        if (left > right) {
            return -1;
        }
        //found target
        if (mid == target) {
            return midIndex;
        }
        else if (mid > target) {
            return bsHelper(left, midIndex-1, nums, target);
        }
        else {
            return bsHelper(midIndex+1, right, nums, target);
        }
    }
}
