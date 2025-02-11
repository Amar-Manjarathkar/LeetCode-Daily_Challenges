# from typing import List, Optional, Set

# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def dfs(self, root: Optional[TreeNode], to_delete: Set[int], forest: List[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return root
        root.left = self.dfs(root.left, to_delete, forest)
        root.right = self.dfs(root.right, to_delete, forest)

        if root.val not in to_delete:
            return root

        if root.left is not None:
            forest.append(root.left)
        if root.right is not None:
            forest.append(root.right)
        root.left = None
        root.right = None
        return None

    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        to_delete_set = set(to_delete)
        forest = []
        root = self.dfs(root, to_delete_set, forest)
        if root is not None:
            forest.append(root)
        return forest
