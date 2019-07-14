dp solution:

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        for (int i = 0; i < n; ++i) {
            int len = Integer.MAX_VALUE;
            for (int j = i; j < n; ++j) {
                len = Math.min(heights[j], len);
                area = Math.max(area, len * (j - i + 1));
            }
        }
        return area;
    }
}
