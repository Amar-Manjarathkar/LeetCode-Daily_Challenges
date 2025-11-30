from typing import List

class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        n = len(nums)
        
        # 1. Calculate the target remainder R
        # R is the required sum % p of the subarray to be removed.
        total_sum_mod = sum(nums) % p
        if total_sum_mod == 0:
            return 0

        R = total_sum_mod

        # 2. Initialize hash map and min_length
        # Stores {prefix_sum % p: index}
        # Start with {0: -1} to handle subarrays starting at index 0.
        remainder_map = {0: -1}
        min_length = n
        current_sum_mod = 0

        # 4. Iterate through the array
        for i in range(n):
            # Update the current prefix sum modulo p
            current_sum_mod = (current_sum_mod + nums[i]) % p
            
            # 5. Calculate the target remainder T we need to find (prefix_sum[j] % p)
            # We want: (current_sum_mod - T) % p == R
            # This is equivalent to: T % p == (current_sum_mod - R + p) % p
            T = (current_sum_mod - R + p) % p
            
            # If the target remainder T is found in the map
            if T in remainder_map:
                # The length of the subarray s[remainder_map[T] + 1 : i + 1] 
                # has the required remainder R.
                subarray_length = i - remainder_map[T]
                min_length = min(min_length, subarray_length)
            
            # Store the current remainder and its index
            remainder_map[current_sum_mod] = i

        # 6. Check the final result
        # If min_length is still n, it means we only found the whole array 
        # as a potential solution, which is disallowed.
        if min_length < n:
            return min_length
        else:
            return -1
