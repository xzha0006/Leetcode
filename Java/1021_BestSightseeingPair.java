class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int n = A.length;
        int most = Integer.MIN_VALUE, best = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            best = Math.max(best, A[i] - i + most);
            most = Math.max(most, A[i] + i);
        }
        return best;
    }
}
