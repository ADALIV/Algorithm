import heapq

def di(map, ori, des):
    # 다익스트라
    short = [None] * len(map)
    short[ori] = 0
    pq = []
    heapq.heappush(pq, (0, ori))
    
    while pq:
        dist, node = heapq.heappop(pq)
        if dist > short[node]:
            continue
        for i in range(1, len(map)):
            if map[node][i] is None:
                continue
            else:
                distance = dist + map[node][i]
                if short[i] is None or distance < short[i]:
                    short[i] = distance
                    heapq.heappush(pq, (distance, i))
    
    # 도달할 수 없다면 float('inf') 반환
    return short[des] if short[des] is not None else float('inf')

def solution(n, s, a, b, fares):
    map = [[None] * (n+1) for _ in range(n+1)]
    for fare in fares:
        c = fare[0]
        d = fare[1]
        f = fare[2]
        map[c][d] = f
        map[d][c] = f
    
    min_cost = float('inf')  # 최단 비용을 무한대로 초기화
    
    # 어떤 공통지점까지 이동
    for i in range(1, n+1):
        # 다익스트라 호출 (출발지 -> 공통지점, 공통지점 -> a, 공통지점 -> b)
        path_common = di(map, s, i)
        path_1 = di(map, i, a)
        path_2 = di(map, i, b)

        # 경로가 존재하지 않으면 skip
        if path_common == float('inf') or path_1 == float('inf') or path_2 == float('inf'):
            continue

        # 경로 비용 계산
        cost = path_common + path_1 + path_2
        min_cost = min(min_cost, cost)
    
    return min_cost if min_cost != float('inf') else -1