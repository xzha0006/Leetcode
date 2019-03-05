class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
		for (int i = 0; i <= nums.length; i++) {
            dfs(nums, i, 0, new ArrayList<>(), ans);
        }
        return ans;
    }
    private void dfs(int[] nums, int length, int start, List<Integer> current, List<List<Integer>> ans) {
        if (current.size() == length) {
            ans.add(new ArrayList<>(current));
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i-1] == nums[i]) continue;
            current.add(nums[i]);
            dfs(nums, length, i + 1, current, ans);
            current.remove(current.size() - 1);
        } 

    }

}
