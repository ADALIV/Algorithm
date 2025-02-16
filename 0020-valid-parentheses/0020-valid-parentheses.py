from collections import deque

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        dq = deque()
        for ch in s:
            if ch=='(' or ch=='{' or ch=='[':
                dq.append(ch)
            elif ch==')':
                if not dq or dq.pop()!='(':
                    return False
            elif ch=='}':
                if not dq or dq.pop()!='{':
                    return False
            elif ch==']':
                if not dq or dq.pop()!='[':
                    return False
        
        if not dq:
            return True
        else:
            return False