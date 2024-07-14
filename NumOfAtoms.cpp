class Solution {
public:
    std::string countOfAtoms(std::string formula) {
        int n = formula.size();
        std::stack<std::map<std::string, int>> stack;
        stack.push({});
        int index = 0;

        while (index < n) {
            if (formula[index] == '(') {
                stack.push({});
                index++;
            } else if (formula[index] == ')') {
                std::map<std::string, int> top = stack.top();
                stack.pop();
                index++;
                int multiplier = 0;
                while (index < n && isdigit(formula[index])) {
                    multiplier = multiplier * 10 + formula[index] - '0';
                    index++;
                }
                multiplier = (multiplier == 0) ? 1 : multiplier;
                for (const auto& kv : top) {
                    stack.top()[kv.first] += kv.second * multiplier;
                }
            } else {
                int start = index;
                index++;
                while (index < n && islower(formula[index])) {
                    index++;
                }
                std::string atom = formula.substr(start, index - start);
                int count = 0;
                while (index < n && isdigit(formula[index])) {
                    count = count * 10 + formula[index] - '0';
                    index++;
                }
                count = (count == 0) ? 1 : count;
                stack.top()[atom] += count;
            }
        }

        std::map<std::string, int> sortedMap = stack.top();
        std::string result;
        for (const auto& kv : sortedMap) {
            result += kv.first;
            if (kv.second > 1) {
                result += std::to_string(kv.second);
            }
        }
        return result;
    }
};


