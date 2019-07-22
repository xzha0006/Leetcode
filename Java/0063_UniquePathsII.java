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

class Solution {
    private int[][] memo;
    private int m, n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(memo[i], -1);
        }
        return findPathNum(obstacleGrid, m - 1, n - 1);
    }
    
    private int findPathNum(int[][] obstacleGrid, int i, int j) {
        if (obstacleGrid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        int res = 0;
        if (i - 1 >= 0 && obstacleGrid[i - 1][j] != 1) {
            res += memo[i - 1][j] != -1 ? memo[i - 1][j] : findPathNum(obstacleGrid, i - 1, j);
        }
        if (j - 1 >= 0 && obstacleGrid[i][j - 1] != 1) {
            res += memo[i][j - 1] != -1 ? memo[i][j - 1] : findPathNum(obstacleGrid, i, j - 1);
        }
        memo[i][j] = res;
        return  res;
    }
}
