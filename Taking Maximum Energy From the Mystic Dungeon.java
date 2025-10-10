class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int maxEnergy = Integer.MIN_VALUE;
        
        // Consider each index in the last k positions (or all) as a potential end of a path
        for (int i = n - 1; i >= Math.max(0, n - k); i--) {
            int currentEnergy = 0;
            // Start from index i and move backward with step k
            for (int j = i; j >= 0; j -= k) {
                currentEnergy += energy[j];
                maxEnergy = Math.max(maxEnergy, currentEnergy);
            }
        }
        
        return maxEnergy;
    }
}
