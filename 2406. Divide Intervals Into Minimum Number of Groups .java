class Solution {
    public int minGroups(int[][] intervals) {
        // Find range
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = intervals.length;
        
        // Correct calculation of min and max
        for (int i = 0; i < n; i++) {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][1]);  // Fixed this line
        }

        // Initialize event count array with size (max + 2) to prevent out of bounds
        int[] eveCount = new int[max + 2];

        // Mark start and end of intervals
        for (int i = 0; i < n; i++) {
            eveCount[intervals[i][0]]++;  // Increment at the start of the interval
            if (intervals[i][1] + 1 <= max + 1) {  // Only decrement if within bounds
                eveCount[intervals[i][1] + 1]--;
            }
        }

        int maxOverlaps = 0;
        int sum = 0;
        
        // Calculate cumulative overlaps
        for (int i = min; i <= max; i++) {  // Iterate only up to max (not max + 2)
            sum += eveCount[i];
            maxOverlaps = Math.max(maxOverlaps, sum);
        }

        return maxOverlaps;
    }
}
