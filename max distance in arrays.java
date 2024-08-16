import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // Initialize min and max with the first array's first and last elements
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDist = 0;
        
        // Iterate over each array starting from the second one
        for (int i = 1; i < arrays.size(); i++) {
            int currentMin = arrays.get(i).get(0);
            int currentMax = arrays.get(i).get(arrays.get(i).size() - 1);
            
            // Compare current array's max with minVal from previous arrays
            maxDist = Math.max(maxDist, Math.abs(currentMax - minVal));
            // Compare current array's min with maxVal from previous arrays
            maxDist = Math.max(maxDist, Math.abs(currentMin - maxVal));
            
            // Update minVal and maxVal
            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }
        
        return maxDist;
    }
}
