class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i, j;
        int[][] solution = new int[m][n];
        solution[0][0] = grid[0][0];
        for(i=1;i<m;i++) {
            solution[i][0] = solution[i-1][0] + grid[i][0];
        }
        for(j=1;j<n;j++) {
            solution[0][j] = solution[0][j-1] + grid[0][j];
        }
        for(i=1;i<m;i++) {
            for(j=1;j<n;j++) {
                solution[i][j] = (solution[i-1][j] < solution[i][j-1] ? solution[i-1][j] :solution[i][j-1]) + grid[i][j];
            }
        }
        return solution[m-1][n-1];
    }
}
