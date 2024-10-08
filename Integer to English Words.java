class Solution {
    String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] belowHundred = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }
    
    private String helper(int num) {
        if (num < 10) {
            return belowTen[num];
        } else if (num < 20) {
            return belowTwenty[num - 10];
        } else if (num < 100) {
            return belowHundred[num / 10] + (num % 10 != 0 ? " " + belowTen[num % 10] : "");
        } else if (num < 1000) {
            return belowTen[num / 100] + " Hundred" + (num % 100 != 0 ? " " + helper(num % 100) : "");
        } else if (num < 1000000) {
            return helper(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + helper(num % 1000) : "");
        } else if (num < 1000000000) {
            return helper(num / 1000000) + " Million" + (num % 1000000 != 0 ? " " + helper(num % 1000000) : "");
        } else {
            return helper(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + helper(num % 1000000000) : "");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberToWords(123)); // One Hundred Twenty Three
        System.out.println(solution.numberToWords(12345)); // Twelve Thousand Three Hundred Forty Five
        System.out.println(solution.numberToWords(1234567)); // One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven
    }
}
