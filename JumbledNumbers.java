class Solution {
    public int[] convertToSys(int[] mapping, int[] nums)
    {
        int n = nums.length;
        int newSys[] = new int[n];
        for(int j=0;j<n;j++)
        {
            int num = nums[j];
            if(num==0)
            {
                newSys[j] = mapping[0];
                continue;
            }
            int i =0;
            int res =0;
            while(num>0)
            {
                int d = num%10; //digit extraction 
                int newD = mapping[d];//conversion
                res = newD*(int)Math.pow(10,i)+res;// formation
                num = num/10;// removal
                i++;//got to next digit

            }
             newSys[j] = res;
        }
        return newSys;
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int newSys[] =convertToSys(mapping, nums);
        Integer index[] = new Integer[n];
        for(int i=0;i<n;i++)
        {
            index[i]=i;
        }
        Arrays.sort(index, new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b)
            {
                return newSys[a] - newSys[b];// increasing order
            }
        });
        int res[]= new int[n];
        int i=0;
        for(int ind: index)
        {
            res[i] = nums[ind];
            i++;
        }
        return res;
    }
}
