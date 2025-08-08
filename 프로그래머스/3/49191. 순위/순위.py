def solution(n, results):
    # 그래프 초기화 (n+1 크기로 설정, 인덱스 1부터 n까지 사용)
    graph = [[False] * (n + 1) for _ in range(n + 1)]
    
    # 결과 반영
    for a, b in results:
        graph[a][b] = True  # a가 b를 이김
    
    # 플로이드-워셜 알고리즘
    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                # i가 k를 이기고 k가 j를 이기면 i가 j를 이김
                if graph[i][k] and graph[k][j]:
                    graph[i][j] = True

    # 정확하게 순위가 매길 수 있는 선수 찾기
    answer = 0
    for i in range(1, n + 1):
        win_count = 0  # 이길 수 있는 선수의 수
        lose_count = 0  # 질 수 있는 선수의 수
        for j in range(1, n + 1):
            if graph[i][j]:  # i가 j를 이김
                win_count += 1
            if graph[j][i]:  # j가 i를 이김
                lose_count += 1
        # win_count + lose_count == n - 1인 경우: i는 정확히 순위가 매길 수 있음
        if win_count + lose_count == n - 1:
            answer += 1
    
    return answer
