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
        visited = [[False] * n for _ in range(m)]
        dq = deque()

        # 상하좌우 방향 (4방향)
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1' and not visited[i][j]:  # grid[i][j] == '1' 체크
                    visited[i][j] = True
                    dq.append((i, j))

                    # BFS 탐색
                    while dq:
                        x, y = dq.popleft()

                        # 4방향 탐색
                        for dx, dy in directions:
                            new_x, new_y = x + dx, y + dy

                            # 새로운 위치가 범위 안에 있고, '1'이고, 아직 방문하지 않은 곳이면
                            if 0 <= new_x < m and 0 <= new_y < n and grid[new_x][new_y] == '1' and not visited[new_x][new_y]:
                                visited[new_x][new_y] = True
                                dq.append((new_x, new_y))

                    land += 1  # 하나의 섬을 찾으면 land를 증가

        return land  # 총 섬의 개수를 반환
