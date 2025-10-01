class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        count,empty=0,0
        while numBottles > 0:
            numBottles-=1
            count+=1
            empty+=1
            if empty>=numExchange:
                numBottles+=empty//numExchange
                empty = empty % numExchange
        return count
        
