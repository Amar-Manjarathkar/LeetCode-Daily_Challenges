class Solution {
    public int minSwaps(int[] nums) {
        int windowSize = 0;
        for(int num : nums)
        {
             windowSize+=num;
            
        }
        int currZeros=0;
        for(int i=0;i<windowSize;i++)
        {
            if(nums[i]==0)
            {
                currZeros++;
            }
        }
        // solve for remaining window
        int minZero=currZeros;
        int start =0;
        int end =windowSize-1;
        int n = nums.length;
        while(start<n)
        {
            //if removed element is 0, decrement the zero counter
            if(nums[start]==0)
            {
                currZeros--;
            }
            start++;
            // if added element is 0, increment the zero counter
            end++;
            if(nums[end%n]==0)
            {
                currZeros++;
            }
            minZero = Math.min(minZero,currZeros);
        }
        
        return minZero;
        
    }
}
