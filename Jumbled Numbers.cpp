class Solution {
public:
    int convert(int num, const std::vector<int>& mapping) {
        if (num == 0) return mapping[0];
        int res = 0, place = 1;
        while (num > 0) {
            res += mapping[num % 10] * place;
            num /= 10;
            place *= 10;
        }
        return res;
    }

    std::vector<int> sortJumbled(std::vector<int>& mapping, std::vector<int>& nums) {
        int n = nums.size();
        std::vector<int> indices(n);
        for (int i = 0; i < n; ++i) {
            indices[i] = i;
        }

        std::sort(indices.begin(), indices.end(), [&](int a, int b) {
            return convert(nums[a], mapping) < convert(nums[b], mapping);
        });

        std::vector<int> result(n);
        for (int i = 0; i < n; ++i) {
            result[i] = nums[indices[i]];
        }
        return result;
    }
};
