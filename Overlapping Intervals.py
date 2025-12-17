class Solution:
    def mergeOverlap(self, arr):
        if not arr:
            return []

        # 1. Sort intervals based on start time
        arr.sort(key=lambda x: x[0])

        # 2. Initialize the result list with the first interval
        merged = [arr[0]]

        for i in range(1, len(arr)):
            current_start, current_end = arr[i]
            last_merged_start, last_merged_end = merged[-1]

            # 3. Check for overlap
            if current_start <= last_merged_end:
                # Merge: Update the end time of the last interval in 'merged'
                merged[-1][1] = max(last_merged_end, current_end)
            else:
                # No overlap: Add the current interval as a new entry
                merged.append([current_start, current_end])

        return merged
