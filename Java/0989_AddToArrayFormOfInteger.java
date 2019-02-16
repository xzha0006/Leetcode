class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> result = new LinkedList<>();
        int tempSum, i, addition = 0;
        for (i = A.length - 1; i >= 0 || K != 0; i--) {
            if (i >= 0) {K += A[i];}
            result.addFirst(K % 10);
            K /= 10;
        }
        return result;
    }
}
