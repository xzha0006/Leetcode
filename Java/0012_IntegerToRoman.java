class Solution {
    public String intToRoman(int num) {
        int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] <= num) {
                    sb.append(strs[i]);
                    num -= nums[i];
                    break;
                }
            }
        }
        return sb.toString();
    }
}
