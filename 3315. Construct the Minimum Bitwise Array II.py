class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        for _i, _num in enumerate(nums):
            original_bin = bin(_num)[2:]

            for _idx, i in enumerate(original_bin):
                if i == "1":
                    temp_str = (original_bin[:_idx] + "0" + original_bin[_idx+1:]) if _idx != 0 else "0" + original_bin[_idx+1:]
                    if int(temp_str,2) | int(temp_str,2) + 1 == _num:
                        nums[_i] = int(temp_str,2)
                        break
            else:
                nums[_i] = -1
        return nums
