class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int n = colors.length();
        
        for (int i = 1; i < n; i++) {
            // If two consecutive balloons have the same color
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // Add the smaller time to total
                totalTime += Math.min(neededTime[i], neededTime[i - 1]);
                
                // Keep the one with larger removal time (simulate keeping it)
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        return totalTime;
    }
}
