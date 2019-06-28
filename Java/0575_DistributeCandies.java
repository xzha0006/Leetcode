class Solution {
    public int distributeCandies(int[] candies) {
        int max = candies.length / 2;
        int size = 0;
        boolean[] map2 = new boolean[200001];
        for (int i: candies) {
            if (!map2[i + 100000]) {
                map2[i + 100000] = true;
                ++size;
            } 
            if (size == max) return max;
        }
        return size;
    }
}
