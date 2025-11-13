class Solution:
    def maxOperations(self, s: str) -> int:
        opertaion_count = 0
        ans = 0
        i = 0
        while i < len(s):
            if s[i] ==  "0":
                while i + 1 < len(s) and s[i+1] == "0":
                    i+=1
                ans += opertaion_count
            else:
                
                opertaion_count += 1
            i+=1
        return ans
        

        
