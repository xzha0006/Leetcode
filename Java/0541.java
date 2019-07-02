class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        if (n < k) return reverse(s);
        else if (n < 2 * k) {
            return reverse(s.substring(0, k)) + s.substring(k);
        }
        else {
            return reverse(s.substring(0, k)) + s.substring(k, 2 * k) + reverseStr(s.substring(2 * k), k);
        }
    }
    
    private String reverse(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n >> 1; ++i) {
            char tmp = chars[n - i - 1];
            chars[n - i - 1] = chars[i];
            chars[i] = tmp;
        }
        return new String(chars);
    }
}
