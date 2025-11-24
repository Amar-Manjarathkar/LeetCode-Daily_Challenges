class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        res = []
        rem = 0
        for bit in nums:
            # Each prefix is prev * 2 + current bit, take mod 5 to avoid large numbers
            rem = (rem * 2 + bit) % 5
            res.append(rem == 0)
        return res
