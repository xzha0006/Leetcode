class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        if (str.charAt(0) == '-') return false;
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            ++left;
            --right;
        }
        return true;
    }
}
