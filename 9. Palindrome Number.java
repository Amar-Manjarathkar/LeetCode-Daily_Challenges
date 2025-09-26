class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindrome
        if (x < 0) return false;

        int original = x;
        int rev = 0;

        while (x > 0) {
            int digit = x % 10;   // extract last digit
            rev = rev * 10 + digit; // build reversed number
            x = x / 10;           // remove last digit
        }

        return rev == original;
    }
}
