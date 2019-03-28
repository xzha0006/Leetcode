class Solution {
    public int romanToInt(String s) {
        int[] a = new int[26];
        a['I' - 'A'] = 1;
        a['V' - 'A'] = 5;
        a['X' - 'A'] = 10;
        a['L' - 'A'] = 50;
        a['C' - 'A'] = 100;
        a['D' - 'A'] = 500;
        a['M' - 'A'] = 1000;
        int res = a[s.charAt(s.length() - 1) - 'A'];
        for (int i = s.length() - 2; i >= 0; --i) {
            int cur = a[s.charAt(i) - 'A'];
            if (cur < a[s.charAt(i + 1) - 'A']) {
                res -= cur;
            } else {
                res += cur;
            }
        } 
        return res;
    }
}
