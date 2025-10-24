class Solution {

    /**
     * Finds the smallest numerically balanced number strictly greater than n.
     */
    public int nextBeautifulNumber(int n) {
        // Start checking every number, beginning with n + 1
        int num = n + 1;
        
        while (true) {
            // If we find a balanced number, return it immediately
            if (isNumericallyBalanced(num)) {
                return num;
            }
            // Otherwise, increment and check the next number
            num++;
        }
    }

    /**
     * Helper function to check if a single number 'n' is numerically balanced.
     */
    private boolean isNumericallyBalanced(int n) {
        // We use an array to store the frequency (count) of each digit.
        // counts[3] will store how many times the digit '3' appears.
        int[] counts = new int[10];
        
        // We use a temporary variable to break the number down
        // without destroying the original 'n' (though 'n' is a copy anyway).
        int temp = n;
        
        while (temp > 0) {
            int digit = temp % 10; // Get the last digit
            
            // --- Crucial Check 1 ---
            // A balanced number can never contain a 0,
            // because the digit '0' would have to appear 0 times.
            if (digit == 0) {
                return false;
            }
            
            counts[digit]++; // Increment the count for this digit
            
            // --- Crucial Check 2 (Fail-Fast Optimization) ---
            // If the count for a digit *already* exceeds its value,
            // we can stop early. For example, in 3333, the 4th '3'
            // makes counts[3] = 4. Since 4 > 3, we know it's invalid.
            if (counts[digit] > digit) {
                return false;
            }
            
            temp = temp / 10; // Move to the next digit
        }
        
        // --- Final Check ---
        // The loop above failed fast for *over-counts*, but we
        // must now check for *under-counts*.
        // Example: For the number 133, the loop finishes with:
        // counts[1] = 1
        // counts[3] = 2
        // We must check that counts[1] == 1 (it is)
        // AND that counts[3] == 3 (it is not!).
        
        for (int i = 1; i <= 9; i++) {
            // If a digit 'i' was present in the number (count > 0),
            // its count must *exactly* equal its value.
            if (counts[i] > 0 && counts[i] != i) {
                return false;
            }
        }
        
        // If we passed all checks, the number is balanced.
        return true;
    }
}
