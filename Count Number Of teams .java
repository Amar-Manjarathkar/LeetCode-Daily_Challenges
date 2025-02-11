class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        for(int mid=1;mid<n-1;mid++) // we dont take first and last element in string 
        {
            int leftSmallerCount=0;
            
            for(int i=0;i<mid;i++)
            {
                if(rating[i]<rating[mid])
                {
                    leftSmallerCount++;
                }
            }
            int rightGreaterCount=0;

             for(int i=mid;i<n;i++)
            {
                if(rating[i]>rating[mid])
                {
                    rightGreaterCount++;
                }
            }
            //increasing order
            count += leftSmallerCount * rightGreaterCount;
            int rightSmallerCount =mid-leftSmallerCount;
            int leftGreaterCount = n-mid-1-rightGreaterCount;

            // decreasing order
            count += rightSmallerCount * leftGreaterCount;
        }
        return count;
        
    }
}
