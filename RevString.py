class Solution:
    def reverseParentheses(self, s: str) -> str:
        stack = []
        
        for char in s:
            if char == ')':
                substring = []
                while stack and stack[-1] != '(':
                    substring.append(stack.pop())
                stack.pop()  # Remove the '('
                stack.extend(substring)
            else:
                stack.append(char)
        
        return ''.join(stack)
