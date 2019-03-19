class Solution {
    int height, width;
    public boolean exist(char[][] board, String word) {
        height = board.length;
        width = board[0].length;
        boolean[][] used = new boolean[height][width];
        boolean res = false;
        for (boolean[] b: used) {
            Arrays.fill(b, false);
        }
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if(board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    res = dfs(board, used, i, j, word.toCharArray(), 0);
                    if (res) return true;
                    used[i][j] = false;
                }
            }
        }
            
        return false;
    }
    private boolean dfs(char[][] board, boolean[][] used, int x, int y, char[] word, int depth) {
        if (depth > word.length || board[x][y] != word[depth]) return false;
        if (depth == word.length - 1 && board[x][y] == word[depth]) {
            return true;
        } 
        if (x + 1 < height && !used[x+1][y]) {
            used[x+1][y] = true;
            if (dfs(board, used, x + 1, y, word, depth + 1)) {
                return true;
            } else {
                used[x+1][y] = false;
            }
        } 
        if (x - 1 >= 0 && !used[x-1][y]) {
            used[x-1][y] = true;
            if (dfs(board, used, x - 1, y, word, depth + 1)) {
                return true;
            } else {
                used[x-1][y] = false;
            }
        } 
        if (y - 1 >= 0 && !used[x][y-1]) {
            used[x][y-1] = true;
            if (dfs(board, used, x, y - 1, word, depth + 1)) {
                return true;
            } else {
                used[x][y-1] = false;
            }
        } 
        if (y + 1 < width && !used[x][y+1]) {
            used[x][y+1] = true;
            if (dfs(board, used, x, y + 1, word, depth + 1)) {
                return true;
            } else {
                used[x][y+1] = false;
            }
        } 
        return false;
    }
}
