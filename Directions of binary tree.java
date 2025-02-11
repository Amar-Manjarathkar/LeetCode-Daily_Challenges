/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        path.append('L');
        if (findPath(root.left, target, path)) {
            return true;
        }
        path.setLength(path.length() - 1);

        path.append('R');
        if (findPath(root.right, target, path)) {
            return true;
        }
        path.setLength(path.length() - 1);
        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = lca(root, startValue, destValue);
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();
        findPath(LCA, startValue, pathToStart);
        findPath(LCA, destValue, pathToDest);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < pathToStart.length(); i++) {
            res.append('U');
        }
        res.append(pathToDest);
        return res.toString();
    }
}
