public class Solution {
    public int myAtoi(String str) {
        int result = 0;
        int bit = 0;
        if (str.trim().length() == 0)
            return 0;
        str = str.trim();
        boolean positive = true;
        
        if (str.charAt(0) == '+')
        {
            str = str.substring(1);
        }
        else if (str.charAt(0) == '-')
        {
            str = str.substring(1);
            positive = false;
        }
        
        for (char c : str.toCharArray())
        {
            bit = c - '0';
            if (bit >= 0 && bit <= 9)
            {
                if (result > (2147483647 - bit) / 10)
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                else
                    result = 10 * result + bit;
            }
            else
                break;
        }
        
        return positive ? result: -result;
    }
}