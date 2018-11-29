class Solution {
    public int shortestBridge(int[][] A) {
        boolean found = false;
        for (int i = 0; !found && i < A.length; i++) {
            //once found an island, break the loops
            for (int j = 0; !found && j < A[0].length; j++) {
                found = findOneIsland(A, i, j);
            }
        }
        
        //expand island 2. After each expand, label++.
        for (int label = 2; label < A.length + A[0].length; label++) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    if (A[i][j] == label && (expand(A, i + 1, j, label) || expand(A, i - 1, j, label) || expand(A, i, j - 1, label) || expand(A, i, j + 1, label))) {
                        return label - 2;
                    }
                }
            }
        }
        return -1;
    }
    //find one island and set its 1s to 2s, then we have island 1 and island 2
    private boolean findOneIsland(int[][] A, int i, int j) {
        if (i < 0 || j < 0 || A.length == i || A[0].length == j || 1 != A[i][j]) {
            return false;
        }
        //if A[i][j] is 1, set it to 2;
        A[i][j] = 2;
        //return the number of 1s in this island
        //important here is '|' not '||'
        return true | findOneIsland(A, i + 1, j) | findOneIsland(A, i - 1, j) | findOneIsland(A, i, j + 1) | findOneIsland(A, i, j - 1);
    }
    
    //expand island 2 until it reached island 1, return if current expand reached island 1
    private boolean expand(int[][] A, int i, int j, int label) {
        if (i < 0 || j < 0 || A.length == i || A[0].length == j) {
            return false;
        }
        else if (0 == A[i][j]) {
            A[i][j] = label + 1;
        }
        return 1 == A[i][j];  
    }
}
