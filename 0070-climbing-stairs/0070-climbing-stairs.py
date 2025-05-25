class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1
        elif n == 2:
            return 2
        
        # 재귀적으로 계산
        return self.climbStairs(n - 1) + self.climbStairs(n - 2)