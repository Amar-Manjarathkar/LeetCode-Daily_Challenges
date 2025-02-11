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
    public TreeNode dfs(TreeNode root, HashSet<Integer> to_delete, List<TreeNode> forest)
    {
        if(root==null)
        {
            return root;
        }
        root.left = dfs(root.left,to_delete,forest);
        root.right = dfs(root.right,to_delete,forest);
        // process the node / root
        if(!to_delete.contains(root.val))
        {
            return root;
        }
        //delete this node 
        if(root.left!=null)
        {
            forest.add(root.left);
        }
        if(root.right!=null)
        {
            forest.add(root.right);
        }
        root.left=null;// delete the pointers
        root.right=null;// delete the pointers
        return null;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // check dependancies before the deletion operation 
        //as all the link to the nodes after the delete node could be lost
        HashSet <Integer> set = new HashSet<>();
        for(int to_be_del : to_delete)
        {
            set.add(to_be_del);
        }
        List<TreeNode> forest = new ArrayList<>();
        root = dfs(root,set, forest);
        if(root!=null)
        {
            forest.add(root);
        }
        return forest;
    } 
}
