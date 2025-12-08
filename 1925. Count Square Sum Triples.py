import math

class Solution:
    def countTriples(self, n: int) -> int:
        """
        Calculates the number of square triples (a, b, c) such that 
        a^2 + b^2 = c^2 and 1 <= a, b, c <= n.
        """
        count = 0
        
        # Iterate over all possible values for 'a' from 1 up to n
        for a in range(1, n + 1):
            # Iterate over all possible values for 'b' from 1 up to n
            for b in range(1, n + 1):
                
                # Calculate c^2 = a^2 + b^2
                c_squared = a*a + b*b
                
                # Calculate c (square root of c_squared)
                c = math.isqrt(c_squared) # Using isqrt for efficient integer square root
                
                # Check if c is within the limit n
                if c > n:
                    # If c is already too large, we can potentially break the inner loop 
                    # if we ensured b >= a, but since we check all pairs, we just continue.
                    continue
                
                # Check if the calculated c is a perfect square root of c_squared, 
                # meaning c^2 == c_squared
                if c * c == c_squared:
                    # If it is, then (a, b, c) is a valid square triple.
                    count += 1
                    
        return count

# Example 1 check:
# sol = Solution()
# print(f"n=5, count: {sol.countTriples(5)}") # Expected: 2 (3,4,5) and (4,3,5)

# Example 2 check:
# print(f"n=10, count: {sol.countTriples(10)}") # Expected: 4 (3,4,5), (4,3,5), (6,8,10), (8,6,10)
