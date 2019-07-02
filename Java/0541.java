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

class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k <= 1) return s;
        
        char[] c = s.toCharArray();
        
        for (int start = 0; start < c.length; start += 2 * k) {
            int end = Math.min(c.length - 1, start + k - 1);
            swap(c, start, end);
        }
        
        return new String(c);
    }
    
    private void swap(char[] c, int i, int j) {
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
                
            i++;
            j--;
        }
    }
}
