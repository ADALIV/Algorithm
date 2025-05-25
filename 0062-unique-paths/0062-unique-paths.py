class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        arr = [[0] * n for _ in range(m)]
        for i in range(0, m):
            for j in range(0, n):
                if i is 0 or j is 0:
                    arr[i][j] = 1
                else:
                    arr[i][j] = arr[i-1][j]+arr[i][j-1]
        return arr[m-1][n-1]