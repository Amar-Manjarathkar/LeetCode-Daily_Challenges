class Solution:
    def constructTransformedArray(self, nums):
        n = len(nums)
        return [nums[((i + nums[i]) % n + n) % n] for i in range(n)]

class Solution:
    def constructTransformedArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [0] * n
        
        for i in range(n):
            # Calculate the new index with circular wrapping
            # Python's % operator handles negative numbers correctly for this
            target_index = (i + nums[i]) % n
            
            # Map the value from the target index to the result
            result[i] = nums[target_index]
            
        return result
