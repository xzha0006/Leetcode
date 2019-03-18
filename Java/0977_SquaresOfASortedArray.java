class Solution {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0)
            return A;
        int[] res = new int[A.length];
        int i = 0, j = A.length - 1, k = j;
        while (k >= 0) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                res[k] = A[i] * A[i];
                ++i;
            } else {
                res[k] = A[j] * A[j];
                --j;
            }
            --k;
        }
        return res;
    }
}
