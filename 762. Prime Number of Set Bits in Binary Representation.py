# class Solution:
#     def prime_set_bits(self,n):
#             prime = [2,3,5,7,11,13,17,19]
#             binary = bin(n)
#             print(binary[2:])
#             count = binary.count("1")
#             if count in prime:
#                 return True
#             return False

#     def countPrimeSetBits(self, left: int, right: int) -> int:
#         count = 0
#         for num in range(left, right+1):
#             if Solution().prime_set_bits(num):
#                 count+=1

#         return count
class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        p = {2, 3, 5, 7, 11, 13, 17, 19}
        r = 0
        for n in range(left,right+1):
            if bin(n).count("1") in p:
                r += 1
        return r        

        
