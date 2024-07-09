class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        # Create a list of friends from 1 to n
        circle: list[int] = [num for num in range(1, n + 1)]
        cur_ind: int = 0

        # Loop until only one friend remains
        while len(circle) > 1:
            # Calculate the index of the next friend to be removed
            next_to_remove: int = (cur_ind + k - 1) % len(circle)
            # Remove the friend at that index
            circle.pop(next_to_remove)
            # Update the current index to the removed friend's index
            cur_ind = next_to_remove

        # Return the last remaining friend
        return circle[0]
