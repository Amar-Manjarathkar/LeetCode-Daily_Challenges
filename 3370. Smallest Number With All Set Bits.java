class Solution {
    public int smallestNumber(int n) {
        long x = 1;
        
        while (x < n) {
            x = (x << 1) | 1;
        }
        
        return (int)x;
    }
}
