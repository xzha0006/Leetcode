ass Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] board = new int[n];
        List<Integer> xAddY = new ArrayList<>();
        List<Integer> xMinusY = new ArrayList<>();
        Arrays.fill(board, -1);
        solve(n, 0, board, xAddY, xMinusY, ans);
        return ans;
    }
    
    private boolean solve(int n, int y, int[] board, List<Integer> xAddY, List<Integer> xMinusY, List<List<String>> ans) {
        if (y == n) {
            ans.add(transferAnswer(board));
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (!isColumnAvailable(board, i) || xAddY.contains(y + i) || xMinusY.contains(y - i)) {
                continue;
            }
            board[y] = i;
            xAddY.add(y + i);
            xMinusY.add(y - i);
            solve(n, y + 1, board, xAddY, xMinusY, ans);
            board[y] = -1;
            xAddY.remove(xAddY.size() - 1);
            xMinusY.remove(xMinusY.size() - 1);
        }
        return false;
        
    }
    private boolean isColumnAvailable(int[] board, int x) {
        for (int i : board) {
            if (i == x) return false;
        }
        return true;
    }
                
    private List<String> transferAnswer(int[] board) {
        List<String> res = new ArrayList<>();
        int n = board.length;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(j == board[i] ? "Q" : ".");
            }
            res.add(sb.toString()); 
        }
        return res;
    }
    
}
