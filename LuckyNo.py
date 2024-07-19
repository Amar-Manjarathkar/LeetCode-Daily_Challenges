class Solution:
    def luckyNumbers (self, matrix: List[List[int]]) -> List[int]:
        res = []
        rows = len(matrix)
        cols = len(matrix[0])

        # Find the minimum value in each row and keep track of their column indices
        row_mins = [0] * rows
        min_cols = [0] * rows
        for i in range(rows):
            min_val = matrix[i][0]
            min_col = 0
            for j in range(1, cols):
                if matrix[i][j] < min_val:
                    min_val = matrix[i][j]
                    min_col = j
            row_mins[i] = min_val
            min_cols[i] = min_col

        # Check if the row minimums are also the maximum in their respective columns
        for i in range(rows):
            min_val = row_mins[i]
            min_col = min_cols[i]
            is_lucky = True
            for k in range(rows):
                if matrix[k][min_col] > min_val:
                    is_lucky = False
                    break
            if is_lucky:
                res.append(min_val)

        return res
