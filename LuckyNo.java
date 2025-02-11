class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int minVal = matrix[i][0];
            int minCol = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    minCol = j;
                }
            }
            
            boolean isLucky = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][minCol] > minVal) {
                    isLucky = false;
                    break;
                }
            }
            
            if (isLucky) {
                res.add(minVal);
            }
        }
        
        return res;
    }
}
