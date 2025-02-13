class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 0 or x == 1:
            return x
        
        left, right = 0, x
        ans = 0  # Store the integer square root
        
        while left <= right:
            mid = (left + right) // 2
            if mid * mid == x:
                return mid
            elif mid * mid < x:
                ans = mid  # Store the possible answer
                left = mid + 1
            else:
                right = mid - 1
        
        return ans  # Return the floored sqrt(x)
