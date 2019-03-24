class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int totalSum = sum(A, 0, A.length);
        if (totalSum % 3 != 0) return false;
        int s1 = totalSum / 3, s2 = s1;
        int firstIdx = 0, secondIdx = A.length - 1;
        // System.out.println(String.format("%d, %d", totalSum, subSum1));
        while (firstIdx < secondIdx) {
            // System.out.println(String.format("%d, %d", A[firstIdx], s1));  
            if (s1 != 0) {
                s1 -= A[firstIdx];
                ++firstIdx;
            }
            if (s2 != 0) {
                s2 -= A[secondIdx];
                --secondIdx;
            }
            if (s1 == 0 && s2 == 0) {
                return true;
            }
        }
        // if (firstIdx < secondIdx - 1) return true;
        // System.out.println(String.format("%d, %d", firstIdx, secondIdx));
        return false;
        
    }
    
    private int sum(int[] A, int start, int length) {
        int res = 0;
        for (int i = start; i < start + length; ++i) {
            res += A[i];
        }
        return res;
    }
}
