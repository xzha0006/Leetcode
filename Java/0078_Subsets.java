class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, i, 0, new ArrayList<>(), ans);
        }
        return ans;
    }

    private void dfs(int[] nums, int k, int s, List<Integer> current, List<List<Integer>> ans) {
        if (current.size() == k) {
            ans.add(new ArrayList<>(current));
        }
        for (int i = s; i < nums.length; i++) {
            current.add(nums[i]);
            dfs(nums, k, i + 1, current, ans);
            current.remove(current.size() - 1);
        } 

    }
}
