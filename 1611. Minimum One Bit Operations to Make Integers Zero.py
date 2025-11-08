# class Solution:
#     def minimumOneBitOperations(self, n: int) -> int:
        # ans = n
        # while n > 0:
        #     n >>= 1
        #     ans ^= n
        # return ans
class Solution:
    def minimumOneBitOperations(self, n: int) -> int:
        binary = bin(n)[2:]
        acc = 0
        sign = 1

        for i in range(len(binary)):
            bit = binary[i]
            if bit == '1':
                acc += sign * (2 ** (len(binary) - i) - 1)
                sign *= -1

        return acc
