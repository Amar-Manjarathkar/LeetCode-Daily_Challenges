class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        vector<int> res;
        int rows = matrix.size();
        int cols = matrix[0].size();
        
        // Find the minimum value in each row and keep track of their column indices
        vector<int> rowMins(rows);
        vector<int> minCols(rows);
        
        for (int i = 0; i < rows; ++i) {
            int minVal = matrix[i][0];
            int minCol = 0;
            for (int j = 1; j < cols; ++j) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    minCol = j;
                }
            }
            rowMins[i] = minVal;
            minCols[i] = minCol;
        }
        
        // Check if the row minimums are also the maximum in their respective columns
        for (int i = 0; i < rows; ++i) {
            int minVal = rowMins[i];
            int minCol = minCols[i];
            bool isLucky = true;
            for (int k = 0; k < rows; ++k) {
                if (matrix[k][minCol] > minVal) {
                    isLucky = false;
                    break;
                }
            }
            if (isLucky) {
                res.push_back(minVal);
            }
        }
        
        return res;
    }
};
