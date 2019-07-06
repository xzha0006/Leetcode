class Solution {
    public int titleToNumber(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int res = 0;
        for (char c: chars) {
            res *= 26;
            res += c - 'A' + 1;
        }
        return res;
    }
}
