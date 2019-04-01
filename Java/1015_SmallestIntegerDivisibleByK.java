class Solution {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) return -1;
        int value = 0;
        // Set<Integer> set = new HashSet<>();
        for (int i = 1; i < K + 1; ++i) {
            value = (10 * value + 1) % K;
            if (value == 0) return i;
            // if (set.contains(value)) return -1;
            // else set.add(value);
        }
        return -1;
    }
}
