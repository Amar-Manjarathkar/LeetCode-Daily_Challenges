class Solution:
    def missingRange(self, arr, low, high):
        #code here
        # res = []
        # seen = []
        # for num in range(low, high+1):
        #     if low <= num <= high:
        #         seen.append(num)
        #         if num not in arr:
        #             res.append(num)
        # return res
        
        # res = [x for x in range(low,high+1)]
        # seen = [ x for x in arr if low <= x <= high]
        # return [x for x in res if x not in seen] 
        seen = set(arr)  # O(n)
        res = []
        
        for num in range(low, high + 1):
            if num not in seen:
                res.append(num)
                
        return res
