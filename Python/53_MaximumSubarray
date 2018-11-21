class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sum = maxSum = nums[0]
        for i in range(1, len(nums)):
            if sum < 0:
                sum = nums[i]
            else:
                sum += nums[i]
            if sum > maxSum:
                maxSum = sum
        return maxSum
