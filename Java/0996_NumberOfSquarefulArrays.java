//DFS solution
class Solution {
    int ans = 0;
    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        // boolean[] used = new boolean[A.length];
        // Arrays.fill(used, false);
        dfs(A, 0, 0, new int[A.length]);
        return ans;
    }
    
    private void dfs(int[] A, int depth, int used, int[] current) {
        if (depth == A.length) {
            ans++;
            return;
        }
        for (int i = 0; i < A.length; i++) {
            if ((used & (1 << i)) != 0) continue;
            if (i > 0 && (A[i-1] == A[i] && (used & (1 << i - 1)) == 0)) continue;
            if (depth == 0 || isSquareful(current[depth-1], A[i])) {
                used |= (1 << i);
                current[depth] = A[i];
                dfs(A, depth + 1, used, current);
                used &= ~(1 << i);
            } else {
                continue;
            }
        }
        
    }
    
    private boolean isSquareful(int x, int y) {
        int s = (int) Math.sqrt(x + y);
        return s * s == x + y;
    }
}
//dp solution
class Solution {
    public int numSquarefulPerms(int[] A) {
        int n = A.length;
        int[][] g = new int[n][n];
        int[][] dp = new int[1 << n][n];
        Arrays.sort(A);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSquareful(A[i], A[j])) {
                    g[i][j] = g[j][i] = 1;
                }
            }
        }
        for (int m = 0; m < n; m++) {
            if (m == 0 || A[m-1] != A[m]) {
                dp[1 << m][m] = 1;
                System.out.println(String.format("%d, %d", (1 << m), m));
            }
        }
        
        for (int s = 1; s < (1 << n); s++) {
            for (int j = 0; j < n; j++) {
                if ((s & (1 << j)) == 0) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (g[j][k] == 0) continue;
                    if (k > 0 && ((s & ~(1 << j)) & (1 << (k - 1))) == 0 && A[k] == A[k-1]) continue;
                    dp[s][j] += dp[s & ~(1 << j)][k];
                    //dp[s | (1 << k)][k] += dp[s][j];
                }
            }
        }
        int ans = 0;
        for (int l = 0; l < n; l++) {
            ans += dp[(1 << n) - 1][l];
        }
        
        return ans;
    }
    
    private boolean isSquareful(int x, int y) {
        int s = (int) Math.sqrt(x + y);
        return s * s == x + y;
    }
}
