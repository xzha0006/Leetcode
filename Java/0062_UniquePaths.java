class Solution {
    public int uniquePaths(int m, int n) {
        int[][] solution = new int[m][n];
        for (int i = 0; i < n; ++i) {
            solution[0][i] = 1;
        }
        for (int j = 0; j < m; ++j) {
            solution[j][0] = 1;
        }
        
        for (int k = 1; k < m; ++k) {
            for (int l = 1; l < n; ++l) {
                solution[k][l] = solution[k - 1][l] + solution[k][l - 1];
            }
        }
        return solution[m-1][n-1];
    }
}
