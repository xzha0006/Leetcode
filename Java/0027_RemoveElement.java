class Solution {
    public int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = j; i > -1; --i) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                --j;
            }
        }
        return j + 1;
    }
}
