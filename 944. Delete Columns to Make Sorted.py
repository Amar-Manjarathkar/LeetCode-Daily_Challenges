class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        n = len(strs)
        s = strs
        count = 0
        for col in range(len(strs[0])):
            for row in range(1,len(strs)):
                if strs[row][col] < strs[row - 1][col]:
                    count+=1
                    break
        # return count
        return sum(col!=sorted(col) for col in map(list,zip(*strs)))
