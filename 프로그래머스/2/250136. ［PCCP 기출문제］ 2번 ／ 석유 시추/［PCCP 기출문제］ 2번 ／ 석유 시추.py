from collections import deque


def bfs(i, j, visited, point, land):
    # 시추 원천 석유 양, 시추 위치 중복 제거용 집합
    k = 0
    s = set()
    q = deque()
    
    q.append((i, j))
    visited[i][j] = True
    k += 1
    s.add(j)
    
    n = len(visited)
    m = len(visited[0])
    
    direction = [(-1, 0), (0, -1), (1, 0), (0, 1)]

    while q:
        x, y = q.popleft()
        for dx, dy in direction:
            new_x = x + dx
            new_y = y + dy
            # 조건문 and 순서 중요
            if 0 <= new_x < n and 0 <= new_y < m and land[new_x][new_y] == 1 and not visited[new_x][new_y]:
                q.append((new_x, new_y))
                visited[new_x][new_y] = True
                k += 1
                s.add(new_y)
    
    for value in s:
        point[value] += k


def solution(land):
    # 모든 땅을 전부 순회하며 해당 열에 플러스
    n = len(land)
    m = len(land[0])
    point = [0] * m
    
    visited = [[False] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and not visited[i][j]:
                bfs(i, j, visited, point, land)
    
    return max(point)