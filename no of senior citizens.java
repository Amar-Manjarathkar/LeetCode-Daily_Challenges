class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        for(String detail : details)
        {
            int a = detail.charAt(11) - '0'; // trick to convert the string cahrecter into integer  
            int b = detail.charAt(12) - '0';
            int ageVal = a*10+b;
            if(ageVal>60)
            {
                count++;
            }
        }
        return count;
        
    }
}
