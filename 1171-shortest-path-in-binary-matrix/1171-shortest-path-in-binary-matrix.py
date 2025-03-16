from collections import deque

class Solution(object):
    def shortestPathBinaryMatrix(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        dq = deque()
        n = len(grid)
        visited = [[False] * n for _ in range(n)]
        timeset = [[-1] * n for _ in range(n)]

        if grid[0][0] == 1 or grid[n-1][n-1] == 1:
            return -1

        dq.append((0, 0))
        visited[0][0] = True
        timeset[0][0] = 1

        directions = [(-1, -1), (1, 1), (-1, 1), (1, -1), (1, 0), (-1, 0), (0, 1), (0, -1)]
        while dq:
            x, y = dq.popleft()
            time = timeset[x][y]
            for dx, dy in directions:
                new_x, new_y = x+dx, y+dy
                if 0<=new_x<n and 0<=new_y<n and grid[new_x][new_y] == 0 and not visited[new_x][new_y]:
                    dq.append((new_x, new_y))
                    visited[new_x][new_y] = True
                    if timeset[new_x][new_y] == -1:
                        timeset[new_x][new_y] = time+1
                    else:
                        timeset[new_x][new_y] = timeset[new_x][new_y] if timeset[new_x][new_y] < time+1 else time+1
            if visited[n-1][n-1]:
                break
        return timeset[n-1][n-1]