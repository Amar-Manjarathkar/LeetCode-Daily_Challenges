class Solution {
public:
    TreeNode* createBinaryTree(std::vector<std::vector<int>>& descriptions) {
        std::unordered_map<int, TreeNode*> nodes;
        std::unordered_set<int> children;
        
        for (const auto& desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            bool is_left = desc[2];
            
            if (nodes.find(parent) == nodes.end()) {
                nodes[parent] = new TreeNode(parent);
            }
            if (nodes.find(child) == nodes.end()) {
                nodes[child] = new TreeNode(child);
            }
            
            if (is_left) {
                nodes[parent]->left = nodes[child];
            } else {
                nodes[parent]->right = nodes[child];
            }
            
            children.insert(child);
        }
        
        for (const auto& desc : descriptions) {
            if (children.find(desc[0]) == children.end()) {
                return nodes[desc[0]];
            }
        }
        
        return nullptr;
    }
};
