class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int left = 0, start = 0;
        int right;
        while (start < S.length()) {
            right = S.lastIndexOf(S.charAt(start));
            while (left < right) {
                int lastPosition = S.lastIndexOf(S.charAt(left));
                if (lastPosition > right) {
                    right = lastPosition;
                }
                left++;
            }
            result.add(right - start + 1);
            start = ++left;
        }
        return result;
    }
}
