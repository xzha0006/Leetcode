class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if (n == 0) return true;
        char[] chars = s.toUpperCase().toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {
            if (chars[left] == chars[right]) {
                ++left;
                --right;
            }
            else if (isValid(chars[left]) && isValid(chars[right])) {
                return false;
            }
            else {
                if(!isValid(chars[left])) {
                    ++left;
                }
                if(!isValid(chars[right])) {
                    --right;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
