class Solution {
public:
    int minOperations(std::vector<std::string>& logs) {
        int level = 0;
        for (const std::string& log : logs) {
            if (log == "../") {
                if (level > 0) {
                    level--;
                }
            } else if (log == "./") {
                continue;
            } else {
                level++;
            }
        }
        return level;
    }
};
