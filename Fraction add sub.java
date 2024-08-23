import java.util.*;

class Solution {
    public String fractionAddition(String expression) {
        // Initialize numerator and denominator
        int numerator = 0, denominator = 1;
        
        // Parse the expression
        int i = 0;
        while (i < expression.length()) {
            // Read the numerator (considering negative sign)
            int start = i;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                i++;
            }
            while (i < expression.length() && expression.charAt(i) != '/' && expression.charAt(i) != '+' && expression.charAt(i) != '-') {
                i++;
            }
            int n = Integer.parseInt(expression.substring(start, i));
            
            // Read the denominator
            i++; // skip '/'
            start = i;
            while (i < expression.length() && expression.charAt(i) != '+' && expression.charAt(i) != '-') {
                i++;
            }
            int d = Integer.parseInt(expression.substring(start, i));
            
            // Calculate the new numerator and denominator using cross multiplication
            numerator = numerator * d + n * denominator;
            denominator *= d;
            
            // Reduce the fraction
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        // Return the result in the desired format
        return numerator + "/" + denominator;
    }
    
    // Helper method to find the greatest common divisor (GCD)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.fractionAddition("-1/2+1/2"));  // Output: "0/1"
        System.out.println(sol.fractionAddition("-1/2+1/2+1/3"));  // Output: "1/3"
        System.out.println(sol.fractionAddition("1/3-1/2"));  // Output: "-1/6"
    }
}
