import java.util.*;

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // Step 1: Initialize the adjacency list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        // Step 2: Initialize distance and frequency arrays
        int[] dist1 = new int[n + 1], dist2 = new int[n + 1], freq = new int[n + 1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[1] = 0;

        // Step 3: Priority queue for BFS
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] {1, 0});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int node = temp[0];
            int timeTaken = temp[1];
            freq[node]++;

            // Step 4: Check if node n is visited for the second time
            if (freq[node] == 2 && node == n) return timeTaken;

            // Step 5: Handle red light
            if ((timeTaken / change) % 2 == 1) {
                timeTaken = change * (timeTaken / change + 1);
            }
            timeTaken += time;

            // Step 6: Process adjacent nodes
            for (int neighbor : adj.getOrDefault(node, Collections.emptyList())) {
                if (freq[neighbor] < 2) {
                    if (dist1[neighbor] > timeTaken) {
                        dist2[neighbor] = dist1[neighbor];
                        dist1[neighbor] = timeTaken;
                        pq.offer(new int[] {neighbor, timeTaken});
                    } else if (dist2[neighbor] > timeTaken && dist1[neighbor] != timeTaken) {
                        dist2[neighbor] = timeTaken;
                        pq.offer(new int[] {neighbor, timeTaken});
                    }
                }
            }
        }

        // Step 7: If no valid second minimum path is found, return -1
        return -1;
    }
}
