class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            if (!checkRow(board[i]) || !checkRow(getColumn(board, i)) || !checkRow(getGrid(board, i))) return false;
        }
        
        return true;
    }
    private char[] getGrid(char[][] board, int grid) {
        char[] res = new char[board.length];
        int count = 0;
        for (int i = grid / 3 * 3; i < grid / 3 * 3 + 3; ++i) {
            for (int j = (grid % 3) * 3; j < (grid % 3) * 3 + 3; ++j) {
                res[count++] = board[i][j];
                // System.out.println(i + ", " + j);
            }
        }
        return res;
    }
    private char[] getColumn(char[][] board, int col) {
        char[] res = new char[board.length];
        for (int i = 0; i < board.length; ++i) {
            res[i] = board[i][col];
            // System.out.println(i + ", " + col + "-" + res[i]);
        }
        return res;
    }
    
    private boolean checkRow(char[] row) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < row.length; ++i) {
            if (row[i] != '.' && map.containsKey(row[i])) {
                return false;
            }
            else {
                map.put(row[i], 1);
            }
        }
        return true;
    }
}
