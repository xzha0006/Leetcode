class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		dfs(n, k, new ArrayList<Integer>(), ans);
		return ans;
    }
    private void dfs(int n, int length, List<Integer> currentComb, List<List<Integer>> ans) {
        if (0 == length) {
            ans.add(new ArrayList<>(currentComb));
        } 
        
        int i;
        for (i = n; i > 0; i--) {
            currentComb.add(i);
            dfs(i - 1, length - 1, currentComb, ans);
            currentComb.remove(currentComb.size() - 1);
        }
    }
}

