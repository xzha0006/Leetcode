class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        for (int i = 0; i < n; ++i) {
            int j;
            for (j = i; j < n; ++j) {
                if (heights[j] < heights[i]) break;
            }
            area = Math.max(area, heights[i] * (j - i));
        }
        return area;
    }
}
