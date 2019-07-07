class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if (n == 0) return true;
        char[] chars = s.toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {
            if (equal(chars[left], chars[right])) {
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
        return (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
    
    private boolean equal(char a, char b) {
        if (((a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z')) && ((b >= 'A' && b <= 'Z') || (b >= 'a' && b <= 'z'))) {
            return a == b || Math.abs(a - b) == ('a' - 'A');
        } else {
            return a == b;
        }
    }
}
