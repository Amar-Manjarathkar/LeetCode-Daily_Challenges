class Solution:
    def romanToInt(self, s: str) -> int:
        roman_to_int = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
            }
        total = 0
        i = 0
        n =  len(s)

        while i < n:
            curr_val = roman_to_int[s[i]]
            next_val = 0
            if i + 1 < n:
                next_val = roman_to_int[s[i+1]]
            if curr_val < next_val:
                total+=(next_val-curr_val)
                i+=2
            else:
                total+=curr_val
                i+=1
        return total


        

            
