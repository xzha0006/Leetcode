class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int min = Integer.MAX_VALUE;
        for (int m = 0; m < strs.length; ++m) {
            min = Math.min(min, strs[m].length());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; ++i) {
            char tmp = strs[0].charAt(i);
            boolean isSame = true;
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].charAt(i) != tmp) {
                    isSame = false;
                }
            }
            if (isSame) {
                sb.append(tmp);
            } else {
                break;
            }
            
        }
        return sb.toString();
    }
}
