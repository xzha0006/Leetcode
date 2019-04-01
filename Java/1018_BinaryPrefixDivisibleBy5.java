class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int n = A.length;
        List<Boolean> res = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < n; ++i) {
            num = (num * 2 + A[i]) % 10;
            res.add(num % 5 == 0);
        }
        return res;
    }
}
