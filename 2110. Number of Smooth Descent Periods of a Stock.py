class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        count = 1
        if not prices:
            return count
        current_streak = 1
        for i in range(1,len(prices)):
            if prices[i] == prices[i-1] -1:
                current_streak+=1
            else:
                current_streak =1
            count+=current_streak
        return count
        
