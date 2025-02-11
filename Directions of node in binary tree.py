# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def lca(self, root: TreeNode, p: int, q: int) -> TreeNode:
        if not root or root.val == p or root.val == q:
            return root
        left = self.lca(root.left, p, q)
        right = self.lca(root.right, p, q)
        if not left:
            return right
        if not right:
            return left
        return root

    def findPath(self, root: TreeNode, target: int, path: list) -> bool:
        if not root:
            return False
        if root.val == target:
            return True
        path.append('L')
        if self.findPath(root.left, target, path):
            return True
        path.pop()
        path.append('R')
        if self.findPath(root.right, target, path):
            return True
        path.pop()
        return False

    def getDirections(self, root: TreeNode, startValue: int, destValue: int) -> str:
        LCA = self.lca(root, startValue, destValue)
        pathToStart, pathToDest = [], []
        self.findPath(LCA, startValue, pathToStart)
        self.findPath(LCA, destValue, pathToDest)
        return 'U' * len(pathToStart) + ''.join(pathToDest)
