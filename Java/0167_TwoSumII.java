class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int sum = numbers[i] + numbers[j];
        int[] res = new int[2];
        while (i < j && sum != target) {
            if (sum > target) --j;
            if (sum < target) ++i;
            sum = numbers[i] + numbers[j];
        }
        res[0] = ++i;
        res[1] = ++j;
        return res;
    }
}
