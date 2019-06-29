class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j > 0 ? dp[i][j - 1] + 1 : 1; 
                } else {
                    dp[i][j] = 0;
                }
                // System.out.print(dp[i][j]);
            }
        }
        int area = 0;
        for (int x = 0; x < dp.length; ++x) {    
            for (int y = 0; y < dp[0].length; ++y) {
                int len = Integer.MAX_VALUE;
                for (int k = x; k < dp.length; ++k) {
                    len = Math.min(len, dp[k][y]);
                    if (len == 0) break;
                    area = Math.max(area, len * (k - x + 1));
                }
            }
        }
        return area;
    }
}
