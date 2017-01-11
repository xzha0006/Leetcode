public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;
        int i = 0, j = 0;
        if (nums1.length > nums2.length)
        {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        int maxLeft, minRight;
        if (m == 0)
            return (nums2[n/2] + nums2[(n - 1) / 2]) / 2.0;
            
        do {
        i = (left + right) / 2;
        j = (m + n) / 2 - i;
        if (i < m && nums1[i] < nums2[j - 1])
            left = i + 1;
        else if (i > 0  && nums2[j] < nums1[i - 1])
            right = i - 1;
        else
            break;
        }while (left <= right);
        
        if (i == 0)
            maxLeft = nums2[j - 1];
        else if (j == 0)
            maxLeft = nums1[i - 1];
        else
            maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
        if (i == m)
            minRight = nums2[j];
        else if (j == n)
            minRight = nums1[i];
        else
            minRight = Math.min(nums1[i], nums2[j]);
        if ((m + n) % 2 == 1)
            return minRight;
            
        return (maxLeft + minRight) / 2.0;
    }
}