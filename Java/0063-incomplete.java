class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] solution = new int[m][n];
        for (int i = 0; i < m; ++i) {
            if (obstacleGrid[i][0] != 1) {
                solution[i][0] = 1;
            } 
            else {
                break;
            }
        }
        for (int j = 0; j < n; ++j) {
            if (obstacleGrid[0][j] != 1) {
                solution[0][j] = 1;
            } 
            else {
                break;
            }
        }
        
        for (int k = 1; k < m; ++k) {
            for (int l = 1; l < n; ++l) {
                if (obstacleGrid[k][l] != 1) {
                    solution[k][l] = solution[k - 1][l] + solution[k][l - 1];
                }
            }
        }
        return solution[m - 1][n - 1];
    }
}
