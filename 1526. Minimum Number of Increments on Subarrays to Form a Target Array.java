class Solution {
    /**
     * Calculates the minimum number of operations to form the target array.
     *
     * The logic is based on observing the difference between adjacent elements.
     * We iterate through the array, keeping track of the `previousValue` we've
     * "built" up to.
     *
     * 1.  Initialize `totalOperations = 0` and `previousValue = 0`.
     * 2.  For the first element `target[0]`, we need `target[0] - 0` operations.
     * We add this to `totalOperations` and set `previousValue = target[0]`.
     * 3.  For any subsequent element `target[i]`:
     * -   If `target[i] > previousValue` (the array "goes up"), it means
     * we need `target[i] - previousValue` *new* operations. These new
     * operations must cover the current index `i`. We add this
     * difference to `totalOperations`.
     * -   If `target[i] <= previousValue` (the array "goes down" or stays
     * level), it means the operations we used for the previous element
     * are sufficient to cover this one. We don't need any new
     * operations. The "extra" operations from the previous step
     * simply stop before reaching index `i`.
     * 4.  In every step, we update `previousValue = target[i]` to prepare for
     * the next comparison.
     *
     * Example: [1, 2, 3, 2, 1]
     * -   `curr = 1`, `prev = 0`. `diff = 1 - 0 = 1`. `ops = 1`. `prev = 1`.
     * -   `curr = 2`, `prev = 1`. `diff = 2 - 1 = 1`. `ops = 1 + 1 = 2`. `prev = 2`.
     * -   `curr = 3`, `prev = 2`. `diff = 3 - 2 = 1`. `ops = 2 + 1 = 3`. `prev = 3`.
     * -   `curr = 2`, `prev = 3`. `diff = 2 - 3 = -1`. `diff` is not positive,
     * `ops` remains 3. `prev = 2`.
     * -   `curr = 1`, `prev = 2`. `diff = 1 - 2 = -1`. `diff` is not positive,
     * `ops` remains 3. `prev = 1`.
     * -   Return 3.
     */
    public int minNumberOperations(int[] target) {
        int totalOperations = 0;
        int previousValue = 0;
        
        for (int currentValue : target) {
            // Calculate the difference needed from the previous height
            int diff = currentValue - previousValue;
            
            // If the current target is higher than the previous,
            // we must add new operations to cover this new height.
            // These operations start at or before this index.
            if (diff > 0) {
                totalOperations += diff;
            }
            
            // If diff <= 0, it means the operations that built the
            // previous element are sufficient (or more than sufficient).
            // No new operations are needed; some old operations just
            // don't extend this far.
            
            // The current value becomes the "previous" value
            // for the next element's comparison.
            previousValue = currentValue;
        }
        
        return totalOperations;
    }
}
