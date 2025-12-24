class Solution:
    def minimumBoxes(self, apple: List[int], capacity: List[int]) -> int:
        total_apples = sum(apple)
        # print(total_apples)
        # cap_sum = 0
        capacity.sort(reverse=True)
        # print(capacity)
        # count=0
        # for c in capacity:
        #     cap_sum+=c
        #     count+=1
        #     if cap_sum > total_apples:
        #         return count
        # return count
        need = 0
        while total_apples > 0:
            total_apples -= capacity[need]
            need += 1
        return need
        

                
