import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return result;

        final int m = heights.length;
        final int n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        ArrayDeque<Integer> pQ = new ArrayDeque<>();
        ArrayDeque<Integer> aQ = new ArrayDeque<>();

        // enqueue Pacific border: top row and left column
        for (int r = 0; r < m; r++) {
            int idx = r * n + 0;
            if (!pac[r][0]) {
                pac[r][0] = true;
                pQ.offer(idx);
            }
        }
        for (int c = 0; c < n; c++) {
            int idx = 0 * n + c;
            if (!pac[0][c]) {
                pac[0][c] = true;
                pQ.offer(idx);
            }
        }

        // enqueue Atlantic border: bottom row and right column
        for (int r = 0; r < m; r++) {
            int idx = r * n + (n - 1);
            if (!atl[r][n - 1]) {
                atl[r][n - 1] = true;
                aQ.offer(idx);
            }
        }
        for (int c = 0; c < n; c++) {
            int idx = (m - 1) * n + c;
            if (!atl[m - 1][c]) {
                atl[m - 1][c] = true;
                aQ.offer(idx);
            }
        }

        bfs(heights, pQ, pac, m, n);
        bfs(heights, aQ, atl, m, n);

        // collect intersection
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pac[r][c] && atl[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    // BFS where queue stores encoded indices (r*n + c)
    private void bfs(int[][] heights, ArrayDeque<Integer> queue, boolean[][] visited, int m, int n) {
        final int[] dr = {1, -1, 0, 0};
        final int[] dc = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            int r = idx / n;
            int c = idx % n;
            int currH = heights[r][c];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;

                // reverse-flow: can move inward only if neighbor height >= current
                if (heights[nr][nc] >= currH) {
                    visited[nr][nc] = true;
                    queue.offer(nr * n + nc);
                }
            }
        }
    }
}
