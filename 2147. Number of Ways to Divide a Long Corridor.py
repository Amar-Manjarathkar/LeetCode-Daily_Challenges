class Solution:
    def numberOfWays(self, corridor: str) -> int:      
        MOD = 10**9 + 7
        seat_indices = [ i for i, char in enumerate(corridor) if char == 'S']
        print(seat_indices)  
        total_seats = len(seat_indices)
        print(total_seats)
        if total_seats == 0 or total_seats % 2 != 0:
            return 0
        result = 1
        for i in range(1, total_seats-1,2):
            end_of_pair = seat_indices[i]
            start_of_next_pair = seat_indices[i+1]
            choices_for_gap = start_of_next_pair - end_of_pair
            result = (result * choices_for_gap) % MOD
        return result
