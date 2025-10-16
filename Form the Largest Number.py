import functools
class Solution:

	def findLargest(self, arr):
	    # code here
	    num_as_str = [str(num) for num in arr]
	    
	    def compare(s1,s2):
	        if s1 + s2 > s2 + s1:
	            return -1
	        else:
	            return 1
	    sorted_nums = sorted(num_as_str, key=functools.cmp_to_key(compare))
	    result = "".join(sorted_nums)
	    if result[0] == '0':
	        return '0'
	    return result
	            
	  
