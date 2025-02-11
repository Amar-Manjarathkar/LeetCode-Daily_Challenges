class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap <String, Integer> freqMap = new HashMap<>();
        for(String str : arr) // code to insert the element and frequency of the element in hash mao 
        {
            freqMap.put(str, freqMap.getOrDefault(str,0)+1); // for first insertion freq = 0+1 for second the freq = prevFreq +1
        }
        for(String str: arr)
        {
            if(freqMap.get(str)==1)
            {
                k--;
            }
            if(k==0)
            {
                return str; // returns the kth string
            }
        }
        return ""; // returns empty string   
    }
}
