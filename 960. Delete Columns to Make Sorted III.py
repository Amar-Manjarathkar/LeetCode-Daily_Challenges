
from typing import List

class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        if not strs:
            return 0
        m = len(strs[0])
        n = len(strs)
        dp = [1] * m
        for j in range(1, m):
            for i in range(j):
                can = True
                for k in range(n):
                    if strs[k][i] > strs[k][j]:
                        can = False
                        break
                if can:
                    dp[j] = max(dp[j], dp[i] + 1)
        max_len = max(dp) if dp else 0
        return m - max_len
