class Solution:
    def kLengthApart(self, nums: list[int], k: int) -> bool:
        # Initialize with -1 to represent that no '1' has been seen yet
        last_seen_index = -1
        
        for i, num in enumerate(nums):
            if num == 1:
                # If this is not the first '1' we've seen
                if last_seen_index != -1:
                    # Check if the distance is strictly greater than k
                    # Equivalent to: (i - last_seen_index - 1) < k
                    if i - last_seen_index <= k:
                        return False
                
                # Update the last seen index to the current one
                last_seen_index = i
                
        return True
