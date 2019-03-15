class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            dfs(i, n, ans);
        }
        return ans;
    }
    private void dfs(int cur, int n, List<Integer> ans) {
        if (cur > n) return;
        ans.add(cur);
        for (int i = 0; i < 10; ++i) {
            dfs(cur * 10 + i, n, ans);
        }
    }
}
