class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length > 0) {
            int originColor = image[sr][sc];
            if (originColor != newColor) {
                // image[sr][sc] = newColor;
                dfs(image, sr, sc, originColor, newColor);
            }
        }
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rowNum = image.length;
        int colNum = image[0].length;
        int nr, nc;
        image[sr][sc] = newColor;
        for (int i = 0; i < move.length; i++) {
            nr = sr + move[i][0];
            nc = sc + move[i][1];
            if (nr >= 0 && nr < rowNum && nc >= 0 && nc < colNum && image[nr][nc] == color ) {
                image[nr][nc] = newColor;
                dfs(image, nr, nc, color, newColor);
            }
        }
    }
}
