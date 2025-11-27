import math

class Solution:
    def maxSubarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        
        # best_min[r] = smallest prefix sum seen so far at an index i with i % k == r
        best_min = [math.inf] * k
        
        prefix = 0  # prefix[0]
        best_min[0] = 0  # index 0 (before any element), 0 % k == 0
        
        max_sum = -math.inf
        
        # i is prefix index: prefix[i] = sum of nums[0..i-1]
        for i in range(1, n + 1):
            prefix += nums[i - 1]        # now prefix = prefix[i]
            r = i % k
            
            if best_min[r] != math.inf:
                # subarray with length divisible by k ending at i-1
                max_sum = max(max_sum, prefix - best_min[r])
            
            best_min[r] = min(best_min[r], prefix)
        
        return max_sum
        
