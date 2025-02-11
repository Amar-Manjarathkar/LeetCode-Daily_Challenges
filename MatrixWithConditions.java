import java.util.*;

class Solution {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Get the topologically sorted sequences for rows and columns
        List<Integer> orderRows = topoSort(rowConditions, k);
        List<Integer> orderColumns = topoSort(colConditions, k);

        // If no topological sort exists, return empty array.
        if (orderRows.isEmpty() || orderColumns.isEmpty()) return new int[0][0];

        // Map each number to its position in the topological order
        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];

        for (int i = 0; i < k; i++) {
            rowPos[orderRows.get(i)] = i;
            colPos[orderColumns.get(i)] = i;
        }

        // Build the matrix
        int[][] matrix = new int[k][k];
        for (int num = 1; num <= k; num++) {
            matrix[rowPos[num]][colPos[num]] = num;
        }

        return matrix;
    }

    private List<Integer> topoSort(int[][] edges, int n) {
        // Initialize adjacency list and indegree array
        List<List<Integer>> adj = new ArrayList<>(n + 1);
        int[] indegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // Kahn's algorithm for topological sorting
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check if topological sort is possible (no cycle)
        if (order.size() == n) {
            return order;
        } else {
            return new ArrayList<>(); // Return empty list if a cycle is detected
        }
    }
}
