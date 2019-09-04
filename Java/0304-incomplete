/**
 * BF solution is O(mn), m is rows, n is cols.
 * A simple dp solution costs: O(mn) for building, O(n) for calling.
 */
class NumMatrix {
    public int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        if (matrix != null && matrix.length > 0) {
            sumMatrix = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[0].length; ++j) {
                    sumMatrix[i][j] = (j > 0 ? sumMatrix[i][j - 1] : 0) + matrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; ++i) {
            res += this.sumMatrix[i][col2] - (col1 > 0 ? this.sumMatrix[i][col1 - 1] : 0);
        }
        return res;
    }
}

