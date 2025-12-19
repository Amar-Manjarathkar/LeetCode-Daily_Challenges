import heapq
from collections import defaultdict
from math import inf

class Solution:
    def findAllPeople(self, n: int, meetings: list[list[int]], firstPerson: int) -> list[int]:
        # Build the graph
        graph = defaultdict(list)
        for x, y, t in meetings:
            graph[x].append((t, y))
            graph[y].append((t, x))

        # earliest[i] stores the earliest time person i knows the secret
        earliest = [inf] * n
        earliest[0] = 0
        earliest[firstPerson] = 0

        # Min-heap stores (time, person)
        pq = [(0, 0), (0, firstPerson)]
        
        while pq:
            time, person = heapq.heappop(pq)
            
            # If we already found a better time for this person, skip
            if time > earliest[person]:
                continue
            
            for t, next_person in graph[person]:
                # Secret can only spread if meeting time >= when current person learned it
                if t >= time and earliest[next_person] > t:
                    earliest[next_person] = t
                    heapq.heappush(pq, (t, next_person))

        return [i for i in range(n) if earliest[i] != inf]
