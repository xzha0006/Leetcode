class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = 0, y1 = 1, x2 = 2, y2 = 3;
        return !(rec1[x2] <= rec2[x1] || rec1[x1] >= rec2[x2] || rec1[y1] >= rec2[y2] || rec1[y2] <= rec2[y1]) ;
    }

}
