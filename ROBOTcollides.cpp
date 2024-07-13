class Solution {
public:
    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, string directions) {
        int n = positions.size();
        vector<int> indices(n);
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        sort(indices.begin(), indices.end(), [&positions](int a, int b) {
            return positions[a] < positions[b];
        });
        
        vector<int> stack;
        for (int i : indices) {
            if (directions[i] == 'R') {
                stack.push_back(i);
            } else {
                while (!stack.empty() && healths[stack.back()] < healths[i]) {
                    healths[i] -= 1;
                    healths[stack.back()] = 0;
                    stack.pop_back();
                }
                if (!stack.empty()) {
                    if (healths[stack.back()] == healths[i]) {
                        healths[stack.back()] = 0;
                        stack.pop_back();
                    } else {
                        healths[stack.back()] -= 1;
                    }
                    healths[i] = 0;
                }
            }
        }
        
        vector<int> result;
        for (int health : healths) {
            if (health > 0) {
                result.push_back(health);
            }
        }
        
        return result;
    }
};
