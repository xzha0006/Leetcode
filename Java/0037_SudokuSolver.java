class Solution {
    final static int SIZE = 9;
    boolean[][] rowConstraints;
    boolean[][] columnConstraints;
    boolean[][] boxConstraints;
    public void solveSudoku(char[][] board) {
        rowConstraints = new boolean[SIZE][SIZE+1];
        columnConstraints = new boolean[SIZE][SIZE+1];
        boxConstraints = new boolean[SIZE][SIZE+1];
        fillWithFalse(rowConstraints);
        fillWithFalse(columnConstraints);
        fillWithFalse(boxConstraints);
        
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                char element = board[y][x];
                if (element != '.') {
                    int num = element - '0';
                    rowConstraints[y][num] = true;
                    columnConstraints[x][num] = true;
                    boxConstraints[3 * (y/3) + x/3][num] = true;
                }
            }
        }
        fill(board, 0, 0);
    }
    
    private boolean fill(char[][] board, int y, int x) {
        if (y == 9) return true;
        int nextX = (x + 1) % 9;
        int nextY = (nextX == 0 ? y + 1 : y);
        if (board[y][x] != '.') {
            return fill(board, nextY, nextX);
        }
        // i is the number which is used to fill the board
        for (int i = 1; i < 10; i++) {
            if (!rowConstraints[y][i] && !columnConstraints[x][i] && !boxConstraints[3 * (y/3) + x/3][i]) {
                board[y][x] = (char) (i + '0');
                rowConstraints[y][i] = true;
                columnConstraints[x][i] = true;
                boxConstraints[3 * (y/3) + x/3][i] = true;
                if (fill(board, nextY, nextX)) return true;
                board[y][x] = '.';
                rowConstraints[y][i] = false;
                columnConstraints[x][i] = false;
                boxConstraints[3 * (y/3) + x/3][i] = false;
            }
        }
        return false;
        
    }
    
    private void fillWithFalse(boolean[][] boolArray) {
        for (boolean[] b: boolArray) {
            Arrays.fill(b, false);
        }
    }
}
