class Solution {
    public boolean isMonotonic(int[] A) {
        int prev = 0, flag = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] == A[i+1]) continue;
            flag = A[i] > A[i+1] ? -1 : 1;
            if (prev != 0 && prev != flag) {
                return false;
            }
            prev = flag;      
        }
        return true;
    }
}
