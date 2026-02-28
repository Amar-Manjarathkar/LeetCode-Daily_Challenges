class Solution:
    def concatenatedBinary(self, n: int) -> int:
        mod = 10**9 + 7
        res_binary = ""
        for i in range(1,n+1):
            binary = bin(i)[2:]
            res_binary += binary
        return int(res_binary,2) % mod

        
