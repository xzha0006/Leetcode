public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int left = 0, right = 0;
        String result = "";
        
        for (int i = 0; i < n; i++)
        {
            int[] odd = findPalindrome(s, i - 1, i + 1);
            int[] even = findPalindrome(s, i - 1, i);
            if (odd[1] - odd[0] > right - left)
            {
                left = odd[0];
                right = odd[1];
            }
            else if(even[1] - even[0] > right - left)
            {
                left = even[0];
                right = even[1];
            }
        }
        
        for (int j = left; j <= right; j++)
        {
            result += String.valueOf(s.charAt(j));
        }
        
        return result;
    }
    
    public int[] findPalindrome(String s, int left, int right) {
        int[] result = new int[2];
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            result[0] = left;
            result[1] = right;
            left--;
            right++;
        }
        return result;
    }
}