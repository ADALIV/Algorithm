from collections import deque

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        land = 0
        m = len(grid)
        n = len(grid[0])
        dq = deque()
        visited = [[False] * n for _ in range(m)]
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1' and not visited[i][j]:
                    dq.append((i, j))
                    visited[i][j] = True
                    
                    while dq:
                        x, y = dq.pop()

                        for dx, dy in directions:
                            new_x, new_y = x+dx, y+dy
                            if 0 <= new_x < m and 0 <= new_y < n and grid[new_x][new_y] == '1' and not visited[new_x][new_y]:
                                dq.append((new_x, new_y))
                                visited[new_x][new_y] = True
                    land += 1
        return land