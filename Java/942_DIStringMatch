class Solution {
    public int[] diStringMatch(String S) {
        int n = S.length();
        int min = 0;
        int max = n;
        int[] result = new int[n+1];
        int i;
        
        for (i=0;i<n;i++) {
            if (S.charAt(i) == 'I') {
                result[i] = min;
                min++;
            }
            else {
                result[i] = max;
                max--;
            }
        }
        result[n] = max;
        return result;
    }
}
