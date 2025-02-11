class Solution:
    def findComplement(self, num: int) -> int:
        # Create a mask that has all bits set to 1 up to the most significant bit of num
        mask = (1 << (num.bit_length())) - 1
        # XOR num with mask to get the complement
        return mask ^ num
