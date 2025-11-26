class Solution:
    def numberOfPaths(self, grid: List[List[int]], k: int) -> int:
        MOD = 10**9 + 7
        m = len(grid)
        n = len(grid[0])
        
        # dp[r][c][rem] stores the number of paths from (0, 0) to (r, c)
        # whose sum has a remainder 'rem' when divided by k.
        # Dimensions: m x n x k
        dp = [[[0] * k for _ in range(n)] for _ in range(m)]
        
        # Base Case: Starting cell (0, 0)
        # The sum is grid[0][0], and the remainder is grid[0][0] % k.
        initial_rem = grid[0][0] % k
        dp[0][0][initial_rem] = 1
        
        # Iterate through the grid
        for r in range(m):
            for c in range(n):
                val = grid[r][c]
                
                # We are calculating dp[r][c][target_rem].
                # target_rem is the final remainder at (r, c).
                for target_rem in range(k):
                    
                    # 1. Paths coming from the cell above (r-1, c)
                    if r > 0:
                        # If the path from (r-1, c) had a remainder 'prev_rem', 
                        # then (prev_rem + val) % k must equal target_rem.
                        # This means: prev_rem = (target_rem - val) % k
                        
                        # We use ((target_rem - val) % k + k) % k to ensure
                        # a non-negative result in the range [0, k-1].
                        prev_rem_r = ((target_rem - val) % k + k) % k
                        dp[r][c][target_rem] = (dp[r][c][target_rem] + dp[r-1][c][prev_rem_r]) % MOD
                        
                    # 2. Paths coming from the cell to the left (r, c-1)
                    if c > 0:
                        # Same logic: prev_rem = (target_rem - val) % k
                        prev_rem_c = ((target_rem - val) % k + k) % k
                        dp[r][c][target_rem] = (dp[r][c][target_rem] + dp[r][c-1][prev_rem_c]) % MOD
                        
        # The problem asks for the number of paths where the sum is divisible by k,
        # which means the remainder must be 0.
        return dp[m-1][n-1][0]
