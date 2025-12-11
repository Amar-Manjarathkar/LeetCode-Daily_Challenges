class Solution:
    def constructArr(self, arr):
        n2 = len(arr)
        if n2 == 0:
            return True  # original array may be size 1
        
        # For original array of size n, pair-sum size = n*(n-1)/2
        # Solve n from equation
        import math
        # n*(n-1)/2 = n2 → n^2 - n - 2*n2 = 0
        n = int((1 + math.isqrt(1 + 8*n2)) // 2)

        if n == 1:
            return True  # any single element is fine

        if n == 2:
            return True  # arr has one sum only - always possible

        # First three sums
        S1 = arr[0]     # a + b
        S2 = arr[1]     # a + c
        S3 = arr[n-1]   # careful: arr[n-1] is b + c (after first block)

        # Find a, b, c
        a = (S1 + S2 - S3) // 2
        b = S1 - a
        c = S2 - a

        res = [0]*n
        res[0], res[1], res[2] = a, b, c

        # Fill remaining values:
        # Next sums involving 'a' are arr[2], arr[3], ...
        for i in range(3, n):
            res[i] = arr[i-1] - a

        return True
