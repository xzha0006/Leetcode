class Solution {
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int a : A) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        return max - min < 2 * K ? 0 : max - min - 2 * K;
    }
}
