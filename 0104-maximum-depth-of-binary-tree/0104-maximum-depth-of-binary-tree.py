# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        if root is None:
            return 0
        max_v = 0
        dq = deque()
        dq.append((root, 1))

        while dq:
            node, depth = dq.popleft()
            max_v = depth
            if node.left:
                dq.append((node.left, depth+1))
            if node.right:
                dq.append((node.right, depth+1))
        return max_v