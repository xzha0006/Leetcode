class Solution {
    public String baseNeg2(int N) {
        if (N == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            int tmp = N % -2;
            N = N / -2;
            if (tmp < 0) {
                ++N;
                tmp = -tmp;
            }
            sb.append(String.valueOf(tmp));
        }
        return sb.reverse().toString();
    }
}
