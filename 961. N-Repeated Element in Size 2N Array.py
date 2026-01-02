# class Solution:
#     def repeatedNTimes(self, nums: List[int]) -> int:
#         seen = {}
#         for num in nums:
#             seen[num] = seen.get(num,0)+1
#             for k,v in seen.items():
#                 if v > 1:
#                     return k

class Solution:
    def repeatedNTimes(self, a: List[int]) -> int:
        d={}
        for i in a:
            if i in d:
                return i
            d[i]=1
