class Solution:
    def xorQueries(self, arr, queries):
        n = len(arr)
        pre = [0] * n
        pre[0] = arr[0]
        for i in range(1, n):
            pre[i] = pre[i - 1] ^ arr[i]
        
        res = []
        for i, j in queries:
            if i == 0:
                res.append(pre[j])
            else:
                res.append(pre[j] ^ pre[i - 1])
        
        return res
