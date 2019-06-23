class Solution {
    public int scoreOfParentheses(String S) {
        return score(S, 0, S.length() - 1);
    }
    private int score(String S, int left, int right) {
        if (right - left == 1) return 1;
        int balance = 0;
        for (int i = left; i < right; ++i) {
            if (S.charAt(i) == '(') {
                ++balance;
            } 
            else if (S.charAt(i) == ')') {
                --balance;
            }
            if (balance == 0) {
                return score(S, left, i) + score(S, ++i, right);
            }
        }
        return 2 * score(S, ++left, --right);
    }
}
