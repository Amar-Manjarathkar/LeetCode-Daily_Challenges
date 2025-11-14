class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        """
        Solves the range addition query problem using a 2D Difference Array (also known as the "difference matrix" or 2D prefix sum "in reverse").

        The core idea is to create a "difference" matrix `mat` of the same size.
        Instead of updating every cell in a submatrix for each query (which is O(n^2) per query),
        we make just four O(1) updates to this difference matrix.

        For a query [r1, c1, r2, c2]:
        1.  `mat[r1][c1] += 1`: This mark indicates that all cells (r, c) where
            r >= r1 and c >= c1 should have 1 added.
        2.  `mat[r2 + 1][c1] -= 1`: This cancels the effect of #1 for all rows
            starting from r2 + 1.
        3.  `mat[r1][c2 + 1] -= 1`: This cancels the effect of #1 for all columns
            starting from c2 + 1.
        4.  `mat[r2 + 1][c2 + 1] += 1`: The effects of #2 and #3 overlapped and
            double-subtracted from the region (r >= r2+1, c >= c2+1).
            This adds 1 back to compensate.

        After processing all queries (O(q) time), the `mat` is a difference matrix.
        We then convert it into the final answer matrix by performing a 2D prefix sum.
        This is done in two passes (O(n^2) time):
        1.  Horizontal Pass: `mat[r][c] += mat[r][c-1]`. This propagates the
            horizontal effects (updates #1 and #3) across each row.
        2.  Vertical Pass: `mat[r][c] += mat[r-1][c]`. This propagates the
            vertical effects (updates #1 and #2) down each column.

        The final time complexity is O(q + n^2), which is much faster than the
        naive O(q * n^2) approach.
        """
        
        # 1. Initialize the n x n difference matrix with zeros.
        # We will use this matrix to store both the differences
        # and the final result to save space.
        mat = [[0] * n for _ in range(n)]
        
        # 2. Apply all query updates to the difference matrix.
        # This step takes O(q) time, where q is the number of queries.
        for r1, c1, r2, c2 in queries:
            # Top-left corner: start of the increment
            mat[r1][c1] += 1
            
            # Top-right corner (exclusive): end horizontal increment
            if c2 + 1 < n:
                mat[r1][c2 + 1] -= 1
            
            # Bottom-left corner (exclusive): end vertical increment
            if r2 + 1 < n:
                mat[r2 + 1][c1] -= 1
            
            # Bottom-right corner (exclusive): compensate for double subtraction
            if r2 + 1 < n and c2 + 1 < n:
                mat[r2 + 1][c2 + 1] += 1
                
        # 3. Reconstruct the final matrix using 2D prefix sums.
        # This step takes O(n^2) time.
        
        # Pass 1: Horizontal prefix sum (propagate left-to-right)
        # After this pass, mat[r][c] will contain the sum of differences
        # in mat[r][0...c].
        for r in range(n):
            for c in range(1, n):
                mat[r][c] += mat[r][c-1]
                
        # Pass 2: Vertical prefix sum (propagate top-to-bottom)
        # After this pass, mat[r][c] will contain the final value,
        # which is the 2D prefix sum of the original difference matrix.
        for r in range(1, n):
            for c in range(n):
                mat[r][c] += mat[r-1][c]
                
        # The 'mat' now holds the final accumulated values
        return mat
