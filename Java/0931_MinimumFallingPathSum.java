ass Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] solution = new int[m][n];
        
        for (int i = 0; i < n; ++i) {
            solution[0][i] = A[0][i];
        } 
        
        int min = Integer.MAX_VALUE;
        for (int j = 1; j < m; ++j) {
            for (int k = 0; k < n; ++k) {
                min = Math.min(solution[j - 1][k], (k > 0 ? solution[j - 1][k - 1] : Integer.MAX_VALUE));
                min = Math.min(min, (k + 1 < n ? solution[j - 1][k + 1] : Integer.MAX_VALUE));
                solution[j][k] = A[j][k] + min;
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int l = 0; l < n; ++l) {
            res = Math.min(solution[m - 1][l], res);
        }
        return res;
        
    }
}
