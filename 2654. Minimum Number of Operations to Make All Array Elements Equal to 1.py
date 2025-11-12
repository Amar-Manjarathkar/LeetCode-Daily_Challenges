import math
from typing import List

class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        
        # --- Case 1: Check for existing 1s ---
        # If we already have at least one '1', we can use it to "infect"
        # all other elements. Each non-1 element will take one operation
        # to be converted (e.g., gcd(x, 1) = 1).
        ones = nums.count(1)
        if ones > 0:
            return n - ones
            
        # --- Case 2: No 1s exist. We must create one. ---
        
        # First, check if it's even possible.
        # If the GCD of the *entire* array is greater than 1 (e.g., [2, 4, 6]),
        # then any GCD operation will always result in a multiple of that GCD.
        # We can never create a 1.
        overall_gcd = nums[0]
        for i in range(1, n):
            overall_gcd = math.gcd(overall_gcd, nums[i])
        
        if overall_gcd > 1:
            return -1

        # --- Case 3: No 1s, but it's possible (overall GCD is 1). ---
        
        # We need to find the *shortest* subarray nums[i...j]
        # such that gcd(nums[i], ..., nums[j]) = 1.
        # Let the length of this shortest subarray be 'min_k'.
        
        min_k = float('inf')
        
        # We check every possible starting point 'i'
        for i in range(n):
            current_gcd = nums[i]
            # And find the shortest subarray *starting* at 'i' with gcd = 1
            for j in range(i + 1, n):
                current_gcd = math.gcd(current_gcd, nums[j])
                if current_gcd == 1:
                    # Found a subarray nums[i...j] with gcd = 1
                    # Length k = (j - i) + 1
                    k = (j - i) + 1
                    min_k = min(min_k, k)
                    # We can break early, since any longer subarray
                    # starting at 'i' will not be shorter.
                    break
        
        # It takes (k - 1) operations to condense a subarray of length 'k'
        # into a single '1'.
        # Example: [a, b, c] -> [a, gcd(b,c)] -> [gcd(a, gcd(b,c))] (2 ops, k=3)
        ops_to_create_first_one = min_k - 1
        
        # Once we have that one '1', it takes (n - 1) more operations
        # to spread it to the other (n - 1) elements.
        ops_to_spread = n - 1
        
        return ops_to_create_first_one + ops_to_spread
