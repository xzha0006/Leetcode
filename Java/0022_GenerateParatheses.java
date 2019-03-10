class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) {
            ans.add("");
            return ans;
        }
        dfs(n, n, "",ans);
        return ans;
    }
    private void dfs(int l, int r, String cur, List<String> ans) {
        if (l == 0 && r == 0) {
            ans.add(cur);
            return;
        }
        if (r < l) return;
        if (l > 0) {
            dfs(l - 1, r, cur + "(", ans);
        }
        if (r > 0) {
            dfs(l, r - 1, cur + ")", ans);
        }
    }
}
