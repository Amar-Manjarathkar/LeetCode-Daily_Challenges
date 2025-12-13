import numpy as np
from scipy import stats
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # nums = np.array(nums)
        # result = stats.mode(nums)
        # return int(result[0])
        nums.sort()
        return nums[len(nums) // 2]
