class Solution:
    def mergeStones(self, stones, k):
        n = len(stones)

        # 1. Handle impossible cases
        if n == 1:
            return 0
        # Each move reduces 'k' piles to 1, a net reduction of (k-1) piles.
        # We need to go from 'n' piles to 1, a reduction of (n-1).
        # Thus, (n-1) must be divisible by (k-1).
        if (n - 1) % (k - 1) != 0:
            return -1

        # 2. Create prefix sums for O(1) range sum queries
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + stones[i]

        def get_sum(i, j):
            # Get sum of stones[i...j] inclusive
            return prefix[j + 1] - prefix[i]

        # 3. Initialize DP table
        # dp[i][j][p] = min cost to merge stones[i..j] into p piles
        # We use 1-based indexing for p (piles), so size is k+1
        dp = [[[float('inf')] * (k + 1) for _ in range(n)] for _ in range(n)]

        # 4. Base Case: A single pile is already 1 pile with 0 cost
        for i in range(n):
            dp[i][i][1] = 0

        # 5. Fill the DP table
        # Iterate by length of the subarray
        for L in range(2, n + 1):  # L = Length
            for i in range(n - L + 1): # i = start
                j = i + L - 1 # j = end

                # a) Calculate cost to get p piles (p > 1)
                for p in range(2, k + 1):
                    # Iterate over possible split points 'm'
                    # Optimization: 'm' must be a point where [i..m] can
                    # be merged into 1 pile. This happens only when
                    # (len - 1) % (k - 1) == 0, i.e., (m - i) % (k - 1) == 0
                    for m in range(i, j, k - 1):
                        if dp[i][m][1] != float('inf') and dp[m + 1][j][p - 1] != float('inf'):
                            dp[i][j][p] = min(dp[i][j][p], dp[i][m][1] + dp[m + 1][j][p - 1])

                # b) Calculate cost to get 1 pile
                # This is the cost to get k piles, plus the cost of the final merge
                cost_to_k_piles = dp[i][j][k]
                if cost_to_k_piles != float('inf'):
                    dp[i][j][1] = cost_to_k_piles + get_sum(i, j)

        # 6. Return the final answer
        # Cost to merge the whole array (0 to n-1) into 1 pile
        result = dp[0][n - 1][1]
        
        return result if result != float('inf') else -1
