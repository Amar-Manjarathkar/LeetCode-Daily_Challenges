class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int n : nums){
            sum += n;
        }
        if(sum % p == 0){
            return 0;
        }

        int r = (int)(sum % p);

        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        prefixSum.put(0, -1);
        int prefix = 0;
        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            prefix = (prefix + nums[i]) % p;
            int mod = (prefix - r + p) % p;
            if(prefixSum.containsKey(mod)){
                int currentLength;
                // if(prefixSum.get(mod) == -1){
                //     currentLength = i - 1;
                // }else{
                    currentLength = i - prefixSum.get(mod);
                // }
                minLength = Math.min(minLength, currentLength);
            }

            prefixSum.put(prefix, i);
        }
        if(minLength < nums.length){
            return minLength;
        }

        return -1;
    }
}
