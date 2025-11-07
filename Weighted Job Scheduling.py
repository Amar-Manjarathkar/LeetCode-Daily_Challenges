from bisect import bisect_right

class Solution:
    def maxProfit(self, jobs):
        if not jobs:
            return 0
        
        # Sort jobs by end time
        jobs.sort(key=lambda x: x[1])
        
        # dp stores tuples: (end_time, max_profit_up_to_this_time)
        # We add a sentinel (0, 0) to handle the base case.
        # The profits in this list will always be monotonically increasing.
        dp = [(0, 0)]
        
        for start, end, profit in jobs:
            # Step 1: Find the latest job that ends <= start
            # We search for 'start' in the end_times of our dp list.
            # bisect_right finds the insertion point for (start, inf).
            # The index i-1 gives the last entry where end_time <= start.
            
            # Note: We search for (start, float('inf')) because bisect_right
            # needs to compare tuples. It will find the index 'i' where
            # all dp[j][0] <= start for j < i.
            i = bisect_right(dp, (start, float('inf')))
            
            # dp[i-1][1] is the max profit we could have made before this job started.
            prev_max = dp[i-1][1]
            
            # Step 2: Calculate the profit if we take this job
            current_profit = prev_max + profit
            
            # Step 3: Update our dp list
            # We only add a new entry if this job gives us a
            # profit *greater* than the last-recorded max profit.
            # If current_profit <= dp[-1][1], it means not taking
            # this job is better. We just carry forward the previous max.
            if current_profit > dp[-1][1]:
                dp.append((end, current_profit))
                
        # The last entry in dp will always have the overall max profit
        return dp[-1][1]
