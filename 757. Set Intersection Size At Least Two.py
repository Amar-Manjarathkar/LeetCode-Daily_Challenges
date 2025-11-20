class Solution:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x: (x[1], -x[0]) )
        size = 0
        p1 = -1
        p2 = -1
        # [Image of the greedy strategy for set intersection]
        for start, end in intervals:
            if start <= p1:
                continue
            elif start <= p2:
                size += 1
                p1 = p2
                p2 = end
            else:
                size += 2
                p1 = end -1
                p2 = end
        return size
