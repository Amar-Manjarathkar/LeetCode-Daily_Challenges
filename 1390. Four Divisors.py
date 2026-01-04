# class Solution:
    
#     def sumFourDivisors(self, nums: List[int]) -> int:
#         total_sum = 0
#         for num in nums:
#             # Removed the incorrect 'if round(sqrt(num)) >= 4' check
#             res = self.find_factors(num)
            
#             # Check if the number of factors is exactly 4
#             if len(res) == 4:
#                 total_sum += sum(res) # Add to the running total (don't overwrite)
        
#         return total_sum
        
#         print(factors)
#     def find_factors(self,n):
#         if n <= 0:
#             return []
#         factors = set()
#         for i in range(1, int(math.sqrt(n)) + 1):
#             if n % i == 0:
#                 factors.add(i)
#                 factors.add(n // i) # Add the pair factor
#         return sorted(list(factors))           
class Solution:
    def sumFourDivisors(self, nums: List[int]) -> int:
        total = 0
        for n in nums:
            divisors = set()
            for i in range(1,int(math.sqrt(n)+1)):
                if n % i == 0:
                    divisors.add(i)
                    divisors.add(n // i)
                if len(divisors) > 4:
                    break
            if len(divisors) == 4:
                total += sum(divisors)
        return total

      
            
        
