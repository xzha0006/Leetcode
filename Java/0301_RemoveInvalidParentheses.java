class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        for (int i = s.length(); i > 0; i--) {
            dfs(s.toCharArray(), i, 0, new StringBuilder(), ans);
            if (ans.size() != 0) {
                break;
            }
        }
        if (ans.size() == 0) {
            ans.add("");
        }
        return ans;
    }
    
    private void dfs(char[] S, int length, int start, StringBuilder cur, List<String> ans) {
        if (cur.length() == length && isValid(cur.toString())) {
            ans.add(cur.toString());
            return;
        }
        for (int i = start; i < S.length; i++) {
            if (i > start && S[i] == S[i-1]) continue;
            cur.append(S[i]);
            dfs(S, length, i + 1, cur, ans);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }
}
