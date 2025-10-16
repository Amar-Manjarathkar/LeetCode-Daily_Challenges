class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] remainderCounts = new int[value];
        for (int num : nums){
            int rem = num % value;
            if (rem < 0){
                rem+=value;
            }
            remainderCounts[rem]++;
        }
        int max = 0;
        while (true){
            int requiredRemainder = max % value;
            if (remainderCounts[requiredRemainder] > 0) {
                remainderCounts[requiredRemainder]--;
                max++;

            } else{
                return max;
            }
        }
        
    }
}
