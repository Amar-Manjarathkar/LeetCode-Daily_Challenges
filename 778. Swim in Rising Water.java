import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        // Min-heap storing {timeNeeded, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];
        
        // start at (0,0) with initial required time = grid[0][0]
        pq.offer(new int[]{grid[0][0], 0, 0});
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], r = cur[1], c = cur[2];
            if (visited[r][c]) continue;
            visited[r][c] = true;
            // if reached target, time is the answer
            if (r == n - 1 && c == n - 1) return time;
            // expand neighbors
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    // required time to step into neighbor is max(current path time, neighbor elevation)
                    int nextTime = Math.max(time, grid[nr][nc]);
                    pq.offer(new int[]{nextTime, nr, nc});
                }
            }
        }
        // problem guarantees a path exists, but return -1 defensively
        return -1;
    }
}
