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
