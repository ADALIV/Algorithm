from collections import deque

def solution(maps):
    # BFS로 최단 거리 계산하기 위한 함수
    
    # 시작(S), 레버(L), 종료(E) 위치 찾기
    start = end = lever = None
    for i, row in enumerate(maps):
        for j, char in enumerate(row):
            if char == 'S':
                start = (i, j)
            elif char == 'L':
                lever = (i, j)
            elif char == 'E':
                end = (i, j)

    # 4방향 탐색 (오른쪽, 아래, 왼쪽, 위)
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

    # BFS 함수: 시작점에서 목표점까지 최단 거리를 계산
    def bfs(start, goal):
        visited = [[False] * len(maps[0]) for _ in range(len(maps))]
        dq = deque([start])
        visited[start[0]][start[1]] = True
        distance = 0
        
        while dq:
            # 티어 1, 티어 2... 전체 pop
            for _ in range(len(dq)):
                x, y = dq.popleft()
                
                # 목표지점에 도달하면 거리 반환
                if (x, y) == goal:
                    return distance
                
                for dx, dy in directions:
                    nx, ny = x + dx, y + dy
                    
                    # 벽을 피하고 유효한 범위인지 확인
                    if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]) and not visited[nx][ny] and maps[nx][ny] != 'X':
                        visited[nx][ny] = True
                        dq.append((nx, ny))
            
            distance += 1
        
        return -1  # 목표지점에 도달할 수 없으면 -1 반환

    # 출발점에서 레버까지의 최단 거리 구하기
    to_lever = bfs(start, lever)
    if to_lever == -1:
        return -1  # 레버까지 도달할 수 없으면 -1 반환
    
    # 레버에서 출구까지의 최단 거리 구하기
    to_exit = bfs(lever, end)
    if to_exit == -1:
        return -1  # 출구까지 도달할 수 없으면 -1 반환
    
    # 출발 -> 레버 -> 출구로 가는 총 시간 반환
    return to_lever + to_exit