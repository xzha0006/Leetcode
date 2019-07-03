class Solution {
    public String addStrings(String num1, String num2) {
        //ensure num1.length() > num2.length()
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = l1 - 1; i >= 0; --i) {
            int sum = 0;
            if (l1 - 1 - i < l2) {
                sum += num2.charAt(i - (l1 - l2)) - '0';
            }
            sum += carry + num1.charAt(i) - '0';
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if (carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
        
    }
}
