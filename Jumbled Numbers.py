class Solution:
    def convert(self, num: int, mapping: list[int]) -> int:
        if num == 0:
            return mapping[0]
        res = 0
        place = 1
        while num > 0:
            res += mapping[num % 10] * place
            num //= 10
            place *= 10
        return res

    def sortJumbled(self, mapping: list[int], nums: list[int]) -> list[int]:
        def converted_value(num):
            return self.convert(num, mapping)
        
        sorted_nums = sorted(nums, key=converted_value)
        return sorted_nums
