class Solution:
    def addBinary(self, a: str, b: str) -> str:
        i, j = len(a) - 1, len(b) - 1
        carry = 0
        res = []

        while i >= 0 or j >= 0 or carry:
            if i >= 0:
                carry += ord(a[i]) - 48   # faster than int()
                i -= 1
            if j >= 0:
                carry += ord(b[j]) - 48
                j -= 1

            res.append(str(carry & 1))   # same as % 2
            carry >>= 1                  # same as // 2

        return ''.join(reversed(res))


# class Solution:
#     def addBinary(self, a: str, b: str) -> str:
#         return bin(int(a, 2) + int(b, 2))[2:]
