class Solution:
    def numTeams(self, rating):
        n = len(rating)
        count = 0
        for mid in range(1, n - 1):
            leftSmallerCount = sum(1 for i in range(mid) if rating[i] < rating[mid])
            rightGreaterCount = sum(1 for i in range(mid + 1, n) if rating[i] > rating[mid])
            
            # increasing order
            count += leftSmallerCount * rightGreaterCount
            
            rightSmallerCount = sum(1 for i in range(mid + 1, n) if rating[i] < rating[mid])
            leftGreaterCount = sum(1 for i in range(mid) if rating[i] > rating[mid])
            
            # decreasing order
            count += rightSmallerCount * leftGreaterCount
            
        return count
