class Solution {
    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0, i, j, steps = 1;
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    startX = j;
                    startY = i;
                } else if (grid[i][j] == 0) {
                    steps++;
                }
            }
        }
        return this.dfs(grid, startX, startY, steps);
        
    }
    
    private int dfs(int[][]grid, int x, int y, int restSteps) {
        if (x < 0 || x == grid[0].length || 
            y < 0 || y == grid.length ||
            grid[y][x] == -1) {
            return 0;
        }
        if (grid[y][x] == 2) {
            return restSteps == 0 ? 1 : 0;
        }
        grid[y][x] = -1; //disable current point 
        int result = dfs(grid, x - 1, y, restSteps - 1) 
            + dfs(grid, x + 1, y, restSteps - 1)
            + dfs(grid, x, y - 1, restSteps - 1)
            + dfs(grid, x, y + 1, restSteps - 1);
        grid[y][x] = 0; //enable current point
        return result;
    }
}
