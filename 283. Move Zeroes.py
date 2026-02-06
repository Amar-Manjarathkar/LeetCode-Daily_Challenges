# class Solution:
#     def moveZeroes(self, nums: List[int]) -> None:
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#         n = len(nums)
#         result = [0] * n
#         j = 0

#         for i in range(n):
#             if nums[i] != 0:
#                 result[j]= nums[i]
#                 j+=1
#         print(result)
#         for i in range(n):
#             nums[i] = result[i]
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        index = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[index], nums[i] = nums[i], nums[index]
                index += 1
        
