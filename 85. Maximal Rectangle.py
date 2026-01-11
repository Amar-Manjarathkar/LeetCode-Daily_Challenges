class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        prev = [0] * (len(matrix[0]) + 1)
        result = 0
        for row in matrix:
            stack = [-1]
            for i, cell in enumerate(row + ["0"]):
                prev[i] = (prev[i] + 1) if cell == "1" else 0
                while (h := prev[stack[-1]]) > prev[i]:
                    stack.pop()
                    if result < (tmp_result := h * (i - stack[-1] - 1)):
                        result = tmp_result
                stack.append(i)
        return result
