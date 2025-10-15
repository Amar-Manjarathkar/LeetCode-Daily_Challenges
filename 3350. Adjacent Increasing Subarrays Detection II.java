import java.util.List;

class Solution {
    /**
     * Finds the maximum length k for which there exist two adjacent, strictly increasing
     * subarrays of length k.
     *
     * @param nums The input list of integers.
     * @return The maximum possible value of k.
     */
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if (n < 2) {
            return 0;
        }

        // L[i]: length of the strictly increasing subarray ending at index i
        int[] L = new int[n];
        L[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                L[i] = L[i - 1] + 1;
            } else {
                L[i] = 1;
            }
        }

        // R[i]: length of the strictly increasing subarray starting at index i
        int[] R = new int[n];
        R[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                R[i] = R[i + 1] + 1;
            } else {
                R[i] = 1;
            }
        }

        int maxK = 0;
        // Iterate through all possible split points (between i-1 and i)
        // and find the maximum k possible at each split.
        for (int i = 1; i < n; i++) {
            int currentK = Math.min(L[i - 1], R[i]);
            maxK = Math.max(maxK, currentK);
        }

        return maxK;
    }
}
