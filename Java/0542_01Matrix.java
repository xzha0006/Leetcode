class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        int i, j;
        int discap = m * n;
        for (i = 0; i < m; ++i) {
            for (j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) res[i][j] = discap;
                if (i > 0) res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                if (j > 0) res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
            }
        }
        
        for (i = m - 1; i >= 0; --i) {
            for (j = n - 1; j >= 0; --j) {
                if (i < m - 1) res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                if (j < n - 1) res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
            }
        }
        return res;
    }
}
