/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    TreeNode* lca(TreeNode* root, int p, int q) {
        if (!root || root->val == p || root->val == q) return root;
        TreeNode* left = lca(root->left, p, q);
        TreeNode* right = lca(root->right, p, q);
        if (!left) return right;
        if (!right) return left;
        return root;
    }

    bool findPath(TreeNode* root, int target, string &path) {
        if (!root) return false;
        if (root->val == target) return true;
        path.push_back('L');
        if (findPath(root->left, target, path)) return true;
        path.pop_back();
        path.push_back('R');
        if (findPath(root->right, target, path)) return true;
        path.pop_back();
        return false;
    }

public:
    string getDirections(TreeNode* root, int startValue, int destValue) {
        TreeNode* LCA = lca(root, startValue, destValue);
        string pathToStart, pathToDest;
        findPath(LCA, startValue, pathToStart);
        findPath(LCA, destValue, pathToDest);
        string res(pathToStart.size(), 'U');
        res += pathToDest;
        return res;
    }
};
