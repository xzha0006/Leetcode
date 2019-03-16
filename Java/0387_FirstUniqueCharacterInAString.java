class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[128];
        for (char c: s.toCharArray()) {
            map[c] = map[c] + 1;
        }
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map[c] == 1) return i;
        }
        return -1;
    }
}
