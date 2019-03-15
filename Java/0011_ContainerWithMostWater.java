class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int max = -1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (max < area) max = area;
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
