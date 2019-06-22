class Solution {
    private int n;
    private int[] dirX = new int[]{2, 2, -2, -2, 1, -1, 1, -1};
    private int[] dirY = new int[]{1, -1, 1, -1, 2, 2, -2, -2};
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        dp[r][c] = 1;
        for (int k = 0; k < K; ++k) {
            double[][] tmpDp = new double[N][N];
            for (int m = 0; m < N; ++m) {
                for (int n = 0; n < N; ++n) {
                    for (int i = 0; i < 8; ++i) {
                        int nr = m - dirX[i];
                        int nc = n - dirY[i];
                        if ((nr >= 0 && nr < N) && (nc >= 0 && nc < N)) { 
                            tmpDp[m][n] += dp[nr][nc];
                        }
                    }
                }
            }
            
            dp = tmpDp;
        }
        double sum = 0;
        for (int m = 0; m < N; ++m) {
            for (int n = 0; n < N; ++n) {
                sum += dp[m][n];
            }
        }
        return sum / Math.pow(8.0, K);
    }
}
