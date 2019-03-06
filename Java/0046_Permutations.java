class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		Arrays.fill(used, false);
		dfs(nums, used, new ArrayList<>(), ans);
        return ans;

    }
    
    private void dfs(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> ans) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            //return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            } 
            current.add(nums[i]);
            used[i] = true;
            dfs(nums, used, current, ans);
            used[i] = false;
            current.remove(current.size() - 1);
        } 

    }

}
