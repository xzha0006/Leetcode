dp solution:
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] lessLeft = new int[n];
        int[] lessRight = new int[n];
        int l, r;
        for (int i = 0; i < n; ++i) {
            l = i - 1;
            while (l >= 0 && heights[l] >= heights[i]) {
                l = lessLeft[l];
            }   
            lessLeft[i] = l;
        }
        for (int j = n - 1; j >= 0; --j) {
            r = j + 1;
            while (r < n && heights[r] >= heights[j]) {
                r = lessRight[r];
            }
            lessRight[j] = r;
        }
        int maxArea = 0;
        for (int k = 0; k < n; ++k) {
            maxArea = Math.max(maxArea, (lessRight[k] - lessLeft[k] - 1) * heights[k]);
        }
        return maxArea;
    }
}

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
