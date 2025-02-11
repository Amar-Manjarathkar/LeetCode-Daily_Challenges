class Solution {
public:
    int numTeams(vector<int>& rating) {
        int n = rating.size();
        int count = 0;
        for (int mid = 1; mid < n - 1; ++mid) {
            int leftSmallerCount = 0, rightGreaterCount = 0;
            for (int i = 0; i < mid; ++i) {
                if (rating[i] < rating[mid]) {
                    leftSmallerCount++;
                }
            }
            for (int i = mid + 1; i < n; ++i) {
                if (rating[i] > rating[mid]) {
                    rightGreaterCount++;
                }
            }
            // increasing order
            count += leftSmallerCount * rightGreaterCount;
            
            int rightSmallerCount = 0, leftGreaterCount = 0;
            for (int i = mid + 1; i < n; ++i) {
                if (rating[i] < rating[mid]) {
                    rightSmallerCount++;
                }
            }
            for (int i = 0; i < mid; ++i) {
                if (rating[i] > rating[mid]) {
                    leftGreaterCount++;
                }
            }
            // decreasing order
            count += rightSmallerCount * leftGreaterCount;
        }
        return count;
    }
};
