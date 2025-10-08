import java.util.Arrays;

class Solution {
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];

        // Sort the potions array to enable binary search.
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            
            // We need to find the smallest potion p such that spell * p >= success.
            // This is equivalent to p >= success / spell.
            // We use ceiling division to find the minimum potion strength required.
            long minPotionStrength = (success + spell - 1) / spell;

            // Use binary search to find the index of the first potion that is strong enough.
            int left = 0;
            int right = m; // Use m as the right boundary for the case where all potions are valid.
            int firstValidIndex = m; // Assume no potion is successful initially.

            while (left < right) {
                int mid = left + (right - left) / 2;
                if ((long) potions[mid] >= minPotionStrength) {
                    firstValidIndex = mid;
                    right = mid; // Try to find an even smaller index on the left.
                } else {
                    left = mid + 1; // The current potion is too weak, search on the right.
                }
            }

            // The number of successful pairs is the total number of potions
            // minus the index of the first successful one.
            pairs[i] = m - firstValidIndex;
        }

        return pairs;
    }
}
