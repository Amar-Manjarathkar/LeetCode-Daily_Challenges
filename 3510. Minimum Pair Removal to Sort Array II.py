# class Node:
#     def __init__(self, value, left):
#         self.value = value
#         self.left = left
#         self.prev = None
#         self.next = None


# class Solution:
#     def minimumPairRemoval(self, nums: List[int]) -> int:
#         class PQItem:
#             def __init__(self, first, second, cost):
#                 self.first = first
#                 self.second = second
#                 self.cost = cost

#             def __lt__(self, other):
#                 if self.cost == other.cost:
#                     return self.first.left < other.first.left
#                 return self.cost < other.cost

#         pq = []
#         head = Node(nums[0], 0)
#         current = head
#         merged = [False] * len(nums)
#         decrease_count = 0
#         count = 0

#         for i in range(1, len(nums)):
#             new_node = Node(nums[i], i)
#             current.next = new_node
#             new_node.prev = current
#             heapq.heappush(
#                 pq, PQItem(current, new_node, current.value + new_node.value)
#             )

#             if nums[i - 1] > nums[i]:
#                 decrease_count += 1

#             current = new_node

#         while decrease_count > 0:
#             item = heapq.heappop(pq)
#             first, second, cost = item.first, item.second, item.cost

#             if (
#                 merged[first.left]
#                 or merged[second.left]
#                 or first.value + second.value != cost
#             ):
#                 continue
#             count += 1

#             if first.value > second.value:
#                 decrease_count -= 1

#             prev_node = first.prev
#             next_node = second.next
#             first.next = next_node
#             if next_node:
#                 next_node.prev = first

#             if prev_node:
#                 if prev_node.value > first.value and prev_node.value <= cost:
#                     decrease_count -= 1
#                 elif prev_node.value <= first.value and prev_node.value > cost:
#                     decrease_count += 1

#                 heapq.heappush(
#                     pq, PQItem(prev_node, first, prev_node.value + cost)
#                 )

#             if next_node:
#                 if second.value > next_node.value and cost <= next_node.value:
#                     decrease_count -= 1
#                 elif second.value <= next_node.value and cost > next_node.value:
#                     decrease_count += 1
#                 heapq.heappush(
#                     pq, PQItem(first, next_node, cost + next_node.value)
#                 )

#             first.value = cost
#             merged[second.left] = True

#         return count

import heapq

class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 1:
            return 0
            
        val = list(nums)
        nextIndices = [0] * n
        prevIndices = [0] * n
        removed = [False] * n
        
        for i in range(n):
            nextIndices[i] = -1 if i == n - 1 else i + 1
            prevIndices[i] = -1 if i == 0 else i - 1
            
        badCount = 0
        for i in range(n - 1):
            if val[i] > val[i + 1]:
                badCount += 1
                
        if badCount == 0:
            return 0
            
        pq = []
        for i in range(n - 1):
            heapq.heappush(pq, (val[i] + val[i + 1], i, i + 1))
            
        ops = 0
        
        while badCount > 0 and pq:
            currSum, u, v = heapq.heappop(pq)
            
            if removed[u] or nextIndices[u] != v or val[u] + val[v] != currSum:
                continue
                
            ops += 1
            h = prevIndices[u]
            w = nextIndices[v]
            
            if val[u] > val[v]:
                badCount -= 1
            if h != -1 and val[h] > val[u]:
                badCount -= 1
            if w != -1 and val[v] > val[w]:
                badCount -= 1
                
            val[u] += val[v]
            removed[v] = True
            nextIndices[u] = w
            
            if w != -1:
                prevIndices[w] = u
                
            if h != -1:
                if val[h] > val[u]:
                    badCount += 1
                heapq.heappush(pq, (val[h] + val[u], h, u))
                
            if w != -1:
                if val[u] > val[w]:
                    badCount += 1
                heapq.heappush(pq, (val[u] + val[w], u, w))
                
        return ops
