class Solution {
    int ans;
    public int totalNQueens(int n) {
        ans = 0;
        int[] board = new int[n];
        List<Integer> xAddY = new ArrayList<>();
        List<Integer> xMinusY = new ArrayList<>();
        Arrays.fill(board, -1);
        solve(n, 0, board, xAddY, xMinusY);
        return ans;
    }
    
    private void solve(int n, int y, int[] board, List<Integer> xAddY, List<Integer> xMinusY) {
        if (y == n) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isColumnAvailable(board, i, y)) {
                continue;
            }
            board[y] = i;
            xAddY.add(y + i);
            xMinusY.add(y - i);
            solve(n, y + 1, board, xAddY, xMinusY);
            board[y] = -1;
            xAddY.remove(xAddY.size() - 1);
            xMinusY.remove(xMinusY.size() - 1);
        }
        return;
        
    }
    private boolean isColumnAvailable(int[] board, int x, int y) {
        for (int i = 0; i < y; i++) {
            if (board[i] == x) return false;
            if (Math.abs(i - y) == Math.abs(board[i] - x)) return false;
        }
        return true;
    }
            
}
