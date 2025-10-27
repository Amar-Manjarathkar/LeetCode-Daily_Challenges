class Solution {
    public int numberOfBeams(String[] bank) {
        int totalBeams = 0;
        int prevRowCount = 0;
        for (String row : bank){
            int currentRowCount = 0;
            for (char ch : row.toCharArray()){
                if(ch == '1'){
                    currentRowCount++;
                }
            }
            if (currentRowCount > 0){
                totalBeams += prevRowCount * currentRowCount;
                prevRowCount = currentRowCount;
            }
        }
        return totalBeams;
    }
}
