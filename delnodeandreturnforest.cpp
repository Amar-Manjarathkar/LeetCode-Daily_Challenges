// #include <vector>
// #include <unordered_set>
// using namespace std;

// struct TreeNode {
//     int val;
//     TreeNode *left;
//     TreeNode *right;
//     TreeNode() : val(0), left(nullptr), right(nullptr) {}
//     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
// };

class Solution {
public:
    TreeNode* dfs(TreeNode* root, unordered_set<int>& to_delete, vector<TreeNode*>& forest) {
        if (root == nullptr) {
            return root;
        }
        root->left = dfs(root->left, to_delete, forest);
        root->right = dfs(root->right, to_delete, forest);

        if (to_delete.find(root->val) == to_delete.end()) {
            return root;
        }

        if (root->left != nullptr) {
            forest.push_back(root->left);
        }
        if (root->right != nullptr) {
            forest.push_back(root->right);
        }
        root->left = nullptr;
        root->right = nullptr;
        return nullptr;
    }

    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
        unordered_set<int> set(to_delete.begin(), to_delete.end());
        vector<TreeNode*> forest;
        root = dfs(root, set, forest);
        if (root != nullptr) {
            forest.push_back(root);
        }
        return forest;
    }
};
