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
