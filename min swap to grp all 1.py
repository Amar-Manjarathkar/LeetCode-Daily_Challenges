class Solution:
    def minSwaps(self, nums):
        window_size = sum(nums)
        
        curr_zeros = 0
        for i in range(window_size):
            if nums[i] == 0:
                curr_zeros += 1
        
        min_zeros = curr_zeros
        n = len(nums)
        for start in range(1, n):
            end = (start + window_size - 1) % n
            if nums[start - 1] == 0:
                curr_zeros -= 1
            if nums[end] == 0:
                curr_zeros += 1
            min_zeros = min(min_zeros, curr_zeros)
        
        return min_zeros
