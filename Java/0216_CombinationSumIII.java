class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<>(), ans);
        return ans;
    }
    private void dfs(int k, int n, int start, List<Integer> current, List<List<Integer>> ans) {
        if (current.size() > k) {
            return;
        } else if (current.size() == k && n == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < 10; i++) {
            current.add(i);
            dfs(k, n - i, i + 1, current, ans);
            current.remove(current.size() - 1);
        }
        
    }
}
