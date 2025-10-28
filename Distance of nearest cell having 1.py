import collections

class Solution:
    def nearest(self, grid):
        rows = len(grid)
        cols = len(grid[0])
        
        # 1. Initialize distance matrix and queue
        # -1 represents an unvisited '0' cell
        distances = [[-1] * cols for _ in range(rows)]
        q = collections.deque()
        
        # 2. Add all '1's as sources to the queue
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1:
                    distances[r][c] = 0
                    q.append((r, c))
        
        # 3. Define the 4-directional movements
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)] # Up, Down, Left, Right
        
        # 4. Process the queue (Multi-Source BFS)
        while q:
            r, c = q.popleft()
            
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                
                # Check for valid and unvisited neighbors
                if 0 <= nr < rows and 0 <= nc < cols and distances[nr][nc] == -1:
                    # Update distance and add to queue
                    distances[nr][nc] = distances[r][c] + 1
                    q.append((nr, nc))
                            
        return distances
