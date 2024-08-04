import java.util.PriorityQueue;

class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int rangeSum(int[] nums, int n, int left, int right) {
        // Priority queue to store subarrays (sum, end_index)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Initialize the priority queue with individual elements of nums
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        int sum = 0;

        // Iterate until the 'right' index
        for (int index = 0; index < right; index++) {
            int[] cur = pq.poll();
            // Add to sum if index is within the range [left, right]
            if (index >= left - 1) {
                sum = (sum + cur[0]) % MOD;
            }
            // If possible, add the next subarray ending at cur[1] + 1
            if (cur[1] + 1 < n) {
                cur[0] += nums[cur[1] + 1];
                cur[1]++;
                pq.offer(cur);
            }
        }

        return sum;
    }
}
