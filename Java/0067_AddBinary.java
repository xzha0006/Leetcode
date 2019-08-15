class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0, sum = 0;
        while (i >= 0 || j >= 0) {
            sum = carry;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            carry = sum / 2;
            sb.append(sum % 2);
            --i;
            --j;
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}