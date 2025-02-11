class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum =0;
        for(int i=0;i<chalk.length;i++)
        {
            sum+=chalk[i];
        }
        int remainingChalk =(int)(k%sum);
        for(int i=0;i<chalk.length;i++)
        {
            if(remainingChalk<chalk[i])
            {
                return i;
            }
            remainingChalk-=chalk[i];
        }
        return -1;
    }
}
