class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSize = -1;
        for (int i = 0; i < m; ++i) {
            dp[i][0] = matrix[i][0] - '0';
            maxSize = Math.max(dp[i][0], maxSize);
        }
        for (int i = 0; i < n; ++i) {
            dp[0][i] = matrix[0][i] - '0';
            maxSize = Math.max(dp[0][i], maxSize);
        }
        
        for (int j = 1; j < m; ++j) {
            for (int k = 1; k < n; ++k) {
                dp[j][k] = matrix[j][k] == '1' ? Math.min(Math.min(dp[j - 1][k], dp[j][k - 1]), dp[j - 1][k - 1]) + 1 : 0;
                maxSize = Math.max(maxSize, dp[j][k]);
            }
        }
    return maxSize * maxSize;
        
    }
}

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j > 0 ? dp[i][j - 1] + 1 : 1;    
                } else {
                    dp[i][j] = 0;
                }
                
            }
        }

        int area = 0;
        for (int k = 0; k < m; ++k) {
            for (int l = 0; l < n; ++l) {
                int depth = 0, minLen = Integer.MAX_VALUE;
                for (int p = k; p < m; ++p) {
                    if (dp[p][l] < depth + 1 || depth > minLen) {
                        break;
                    } else {
                        minLen = Math.min(minLen, dp[p][l]);
                        depth++;
                        if (minLen == depth) {
                            area = Math.max(minLen * depth, area);
                        }
                    }
                }
            }
        }
        return area;
    }
}
