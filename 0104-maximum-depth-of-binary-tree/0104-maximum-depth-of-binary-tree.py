# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        max_depth = self.DFS(root, 1)
        return max_depth
    def DFS(self, root, cnt):
        if root is None:
            return cnt - 1
        
        # 왼쪽과 오른쪽 서브트리의 깊이를 초기화
        lv = rv = cnt
        
        if root.left:
            lv = self.DFS(root.left, cnt + 1)  # 왼쪽 서브트리 깊이 계산
        if root.right:
            rv = self.DFS(root.right, cnt + 1)  # 오른쪽 서브트리 깊이 계산

        return max(lv, rv)