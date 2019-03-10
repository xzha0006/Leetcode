//DFS + Pruning
class Solution {
    int[][] g;
    int[] bestPath;
    int bestLength = Integer.MAX_VALUE;
    public String shortestSuperstring(String[] A) {
        g = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                g[i][j] = overlapLength(A[i], A[j]);
            }
        }
        boolean[] used = new boolean[A.length];
        Arrays.fill(used, false);
        dfs(A, 0, new int[A.length], 0, used);
        String res = A[bestPath[0]];
        for (int i = 1; i < bestPath.length; i++) {
            res = combine(res, A[bestPath[i]]);
            System.out.print("" + bestPath[i] + " ");
        }
        return res;
    }
    
    private void dfs(String[] A, int depth, int[] path, int currentLength, boolean[] used) {
        if (currentLength > bestLength) return;
        if (depth == A.length) {
            bestPath = path.clone();
            bestLength = currentLength;
        }
        for (int i = 0; i < A.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path[depth] = i;
            dfs(A, 
                depth + 1, 
                path, 
                depth == 0 ? A[i].length() : currentLength + A[i].length() - g[path[depth-1]][i], 
                used);
            used[i] = false;
            path[depth] = -1;
        }
    }
    private String combine(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.substring(i).endsWith(s2.substring(0, Math.min(s2.length(), s1.length() - i)))) {
                return s1 + s2.substring(Math.min(s2.length(), s1.length() - i));
            }
        }
        return s1 + s2;
        
    }
    
    private int overlapLength(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.substring(i).endsWith(s2.substring(0, Math.min(s2.length(), s1.length() - i)))) {
                return s1.length() - i;
            }
        }
        return 0;
        
    }
}
//DP solution
class Solution {
    public String shortestSuperstring(String[] A) {
        int n = A.length;
        int[][] cost = new int[n][n];
        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];
        //calculate cost matrix
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                cost[i][j] = A[j].length() - overlapLength(A[i], A[j]);
            }
        }
        for (int[] intArray: dp) {
            Arrays.fill(intArray, Integer.MAX_VALUE / 2);
        }
        for (int[] intArray: parent) {
            Arrays.fill(intArray, -1);
        }
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = A[i].length();
        }
        
        for (int s = 1; s < (1 << n); s++) {
            for (int j = 0; j < n; j++) {
                if ((s & (1 << j)) == 0) {
                    continue;
                }
                int parentS = s & ~(1 << j);
                for (int k = 0; k < n; k++) {
                    if (dp[parentS][k] + cost[k][j] < dp[s][j]) {
                        dp[s][j] = dp[parentS][k] + cost[k][j];
                        parent[s][j] = k;
                    }
                }
            }
        }
        int min = dp[(1 << n) - 1][0];
        int minIndex = 0;
        for (int m = 0; m < n; m++) {
            //System.out.println("" + dp[(1 << n) - 1][m]);
            if (dp[(1 << n) - 1][m] < min) {
                minIndex = m;
                min = dp[(1 << n) - 1][m];
            }
        }
        int s = (1 << n) - 1;
        int previousIndex = 0;
        String ans = "";
        //System.out.println("" + minIndex);
        while (s != 0) {
            previousIndex = parent[s][minIndex];
            
            if (previousIndex >= 0) {
                // System.out.println("++" + A[previousIndex]);
                ans = A[minIndex].substring(A[minIndex].length() - cost[previousIndex][minIndex]) + ans;
            } else {
                // System.out.println("--" + A[minIndex]);
                ans = A[minIndex] + ans;
            }
            s &= ~(1 << minIndex);
            minIndex = previousIndex;
            //System.out.println(ans);
        }  
        return ans;
    }
    
    
    private String combine(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.substring(i).endsWith(s2.substring(0, Math.min(s2.length(), s1.length() - i)))) {
                return s1 + s2.substring(Math.min(s2.length(), s1.length() - i));
            }
        }
        return s1 + s2;
        
    }
    
    private int overlapLength(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.substring(i).endsWith(s2.substring(0, Math.min(s2.length(), s1.length() - i)))) {
                return s1.length() - i;
            }
        }
        return 0;
        
    }
}
