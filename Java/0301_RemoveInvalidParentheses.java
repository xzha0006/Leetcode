class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l == 0) {
                    r++;
                } else {
                    l--;
                }
            }
        }
        System.out.println(String.format("%d, %d", l, r));
        List<String> ans = new ArrayList<>();
        dfs(s, l, r, 0, ans);
        return ans;
    }
    
    private void dfs(String s, int l, int r, int start, List<String> ans) {
        if (l == 0 && r == 0) {
            if (isValid(s)) {
                ans.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i-1)) continue;
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {              
                if (r > 0 && s.charAt(i) == ')') {
                    dfs(s.substring(0, i) + s.substring(i + 1, s.length()), l, r - 1, i, ans);
                } else if (l > 0 && s.charAt(i) == '(') {
                    dfs(s.substring(0, i) + s.substring(i + 1, s.length()), l - 1, r, i, ans);
                }
            }
            
        }
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}

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
