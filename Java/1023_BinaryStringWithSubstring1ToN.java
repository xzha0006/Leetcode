class Solution {
    public boolean queryString(String S, int N) {
        for (int i = 1; i <= N; ++i) {
            String str = Integer.toBinaryString(i);
            if (S.indexOf(str) == -1) return false;
        }
        return true;
    }
}
