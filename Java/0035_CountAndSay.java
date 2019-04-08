class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String str = countAndSay(--n);
        int count = 1, i;
        StringBuilder sb = new StringBuilder();
        for (i = 1; i < str.length(); ++i) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                ++count;
            } else {
                sb.append(count).append(str.charAt(i - 1));
                count = 1;
            }
        }
        sb.append(count).append(str.charAt(i - 1));
        return sb.toString();
    }
}
