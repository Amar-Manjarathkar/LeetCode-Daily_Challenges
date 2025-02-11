class Solution {
public:
    int maximumGain(string s, int x, int y) {
        // Determine high and low priority pairs
        string highPriorityPair = x > y ? "ab" : "ba";
        string lowPriorityPair = x > y ? "ba" : "ab";
        int highValue = max(x, y);
        int lowValue = min(x, y);

        // First pass: remove high priority pairs and calculate score
        auto firstPassResult = removePairs(s, highPriorityPair);
        int totalScore = firstPassResult.second * highValue;

        // Second pass: remove low priority pairs and calculate score
        auto secondPassResult = removePairs(firstPassResult.first, lowPriorityPair);
        totalScore += secondPassResult.second * lowValue;

        return totalScore;
    }

private:
    pair<string, int> removePairs(const string& s, const string& pair) {
        string result;
        int count = 0;
        for (char c : s) {
            if (!result.empty() && result.back() == pair[0] && c == pair[1]) {
                result.pop_back();
                count++;
            } else {
                result.push_back(c);
            }
        }
        return {result, count};
    }
};
