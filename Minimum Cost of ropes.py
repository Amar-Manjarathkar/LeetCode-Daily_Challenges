import heapq
class Solution:
  def minCost(self, arr):
    # code here
    
    min_cost=0
    heapq.heapify(arr)
    while len(arr) > 1:
        rope1=heapq.heappop(arr)
        rope2=heapq.heappop(arr)
        cur_cost=rope1+rope2
        min_cost+=cur_cost
        heapq.heappush(arr,cur_cost)
        
    
        
    return min_cost
    
    
# import heapq

# class Solution:
#     # Function to return the minimum cost of connecting the ropes.
#     def minCost(self, arr):
        
#         # If there are 0 or 1 ropes, no connections are needed, so the cost is 0.
#         if len(arr) <= 1:
#             return 0
            
#         # Convert the list into a min-heap in-place.
#         # This is an O(n) operation.
#         heapq.heapify(arr)
        
#         min_cost = 0
        
#         # Loop as long as there is more than one rope in the heap.
#         # This loop will run (n-1) times.
#         while len(arr) > 1:
            
#             # 1. Pop the smallest rope. O(log n)
#             rope1 = heapq.heappop(arr)
            
#             # 2. Pop the second-smallest rope. O(log n)
#             rope2 = heapq.heappop(arr)
            
#             # 3. The cost of this connection is their sum.
#             current_cost = rope1 + rope2
            
#             # 4. Add this cost to the total.
#             min_cost += current_cost
            
#             # 5. Push the new, combined rope back into the heap. O(log n)
#             heapq.heappush(arr, current_cost)
            
#         # The loop ends when only one rope is left in the heap.
#         # We return the total accumulated cost.
#         return min_cost
    
