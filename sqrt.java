class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        long guess = x; // Start with x to ensure convergence
        while (guess * guess > x) {
            guess = (guess + x / guess) / 2;
        }
        
        return (int) guess; // Return the integer part (floor value)
    }
}
