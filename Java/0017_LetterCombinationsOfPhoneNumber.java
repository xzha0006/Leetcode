//BFS solution important!
class Solution {
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        ans.add("");
        for (char digit: digits.toCharArray()) {
            List<String> tmp = new ArrayList<>();
            for (String s: ans) {
                String letters = map[digit - '0'];
                for (char c: letters.toCharArray()) {
                    tmp.add(s + c);   
                }
            }
            ans = tmp;
        }
        return ans;
    }
}

//DFS solution
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        char[] cur = new char[digits.length()];
        dfs(ans, digits, map, 0, cur);
        return ans;
    }
    
    private void dfs(List<String> ans, String digits, String[] map, int level, char[] cur) {
        if (level == digits.length()) {
            ans.add(new String(cur));
            return;
        }
        for (char c: map[digits.charAt(level) - '0'].toCharArray()) {
            cur[level] = c;
            dfs(ans, digits, map, level + 1, cur);
        }
    }
}
