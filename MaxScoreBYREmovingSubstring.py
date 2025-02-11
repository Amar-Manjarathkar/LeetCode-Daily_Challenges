class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        def remove_substring(input: str, target_pair: str) -> (str, int):
            char_stack, count = [], 0
            for char in input:
                if char_stack and char_stack[-1] == target_pair[0] and char == target_pair[1]:
                    char_stack.pop()
                    count += 1
                else:
                    char_stack.append(char)
            return "".join(char_stack), count

        high_priority_pair, low_priority_pair = ("ab", "ba") if x > y else ("ba", "ab")
        s, high_count = remove_substring(s, high_priority_pair)
        s, low_count = remove_substring(s, low_priority_pair)

        return high_count * max(x, y) + low_count * min(x, y)
