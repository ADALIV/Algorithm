# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class FindElements(object):

    def __init__(self, root):
        """
        :type root: Optional[TreeNode]
        """
        self.data = set()
        self.data.add(0)
        self.root = root
        self.root.val = 0
        dq = deque()
        dq.append(self.root)

        while dq:
            n = dq.popleft()
            if n.left:
                n.left.val = 2*n.val + 1
                self.data.add(n.left.val)
                dq.append(n.left)
            if n.right:
                n.right.val = 2*n.val + 2
                self.data.add(n.right.val)
                dq.append(n.right)
        

    def find(self, target):
        """
        :type target: int
        :rtype: bool
        """

        if target in self.data:
            return True
        else:
            return False


# Your FindElements object will be instantiated and called as such:
# obj = FindElements(root)
# param_1 = obj.find(target)