//dfs solution
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        dfs(S.toCharArray(), 0, ans);
        return ans;
    }
    private void dfs(char[] S, int i, List<String> ans) {
        if (i == S.length) {
            ans.add(new String(S));
            return;
        }
        dfs(S, i + 1, ans);
        if (Character.isLetter(S[i])) {
            S[i] ^= 1 << 5;
            dfs(S, i + 1, ans);
            S[i] ^= 1 << 5;
        }
    }
}
//BFS solution
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        ans.add(S);
        for (int i = 0; i < S.length(); i++) {
            for (int j = ans.size() - 1; Character.isLetter(S.charAt(i)) && j >=0; j--) {
                char[] chars = ans.get(j).toCharArray();
                chars[i] ^= 1 << 5;
                ans.add(new String(chars));
            }
        }
        return ans;
    }
}
