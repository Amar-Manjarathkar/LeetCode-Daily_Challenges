class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()
        res = []
        n = len(arr)
        _min = 100000000000
        for i in range(1,n):
            diff = arr[i] - arr[ i - 1]
            if diff < _min:
                _min = diff
                res = [[arr[i - 1], arr[i]]]
            elif diff == _min:
                res.append([arr[i - 1], arr[i]])
        return res

        
class Solution:
  def minimumAbsDifference(self, arr: list[int]) -> list[list[int]]:
    ans = []
    mn = math.inf

    arr.sort()

    for a, b in itertools.pairwise(arr):
      diff = b - a
      if diff < mn:
        mn = diff
        ans = []
      if diff == mn:
        ans.append([a, b])

    return ans
