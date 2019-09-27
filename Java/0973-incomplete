class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Integer[][] distances = new Integer[points.length][2];
        for (int i = 0; i < points.length; ++i) {
            distances[i][0] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            distances[i][1] = i;
        }
        Arrays.sort(distances, (Integer[] x, Integer[] y) -> {
            if (x[0] > y[0]) return 1;
            if (x[0] < y[0]) return -1;
            return 0;
        });
        int[][] result = new int[K][2];
        for (int j = 0; j < K; j++) {
            result[j][0] = points[distances[j][1]][0];
            result[j][1] = points[distances[j][1]][1];
        }
        return result;
    }
}
