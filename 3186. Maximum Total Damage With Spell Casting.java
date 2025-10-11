class Solution {
    public long maximumTotalDamage(int[] power) {
        if (power == null || power.length == 0){
            return 0;
        }
        Map<Integer, Integer> counts = new HashMap<>();
        for (int p : power){
            counts.put(p,counts.getOrDefault(p, 0)+1);
        }
        List<Integer> uniquePowers = new ArrayList<>(counts.keySet());
        Collections.sort(uniquePowers);
        int n = uniquePowers.size();
        long[] dp = new long[n];

        dp[0] = (long) uniquePowers.get(0) * counts.get(uniquePowers.get(0));
        int j = -1;

        for(int i = 1 ; i<n; i++){
            int currentPower = uniquePowers.get(i);
            long skipDamage = dp[i-1];
            long castDamage = (long) currentPower *  counts.get(currentPower);
            while(j + 1 < i && uniquePowers.get(j + 1) < currentPower -2){
                j++;
            }
            if (j!=-1){
                castDamage += dp[j];
            }
            dp[i] = Math.max(skipDamage, castDamage);
        }
        return dp[n-1];
    }
}
