class Solution {
public:
    int findComplement(int num) {
        // Create a mask that has all bits set to 1 up to the most significant bit of num
        int mask = (1 << (int)(log2(num) + 1)) - 1;
        // XOR num with mask to get the complement
        return mask ^ num;
    }
};
