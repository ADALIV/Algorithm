import heapq

class Solution(object):
    def networkDelayTime(self, times, n, k):
        """
        :type times: List[List[int]]
        :type n: int
        :type k: int
        :rtype: int
        """
        # 힙과 가중치 초기화
        heap = []
        weights = [float('inf')] * n  # 모든 노드는 처음에 무한대
        weights[k-1] = 0  # 시작 노드는 0으로 초기화
        visited = [False] * n  # 방문 여부
        nodeArr = [[] for _ in range(n)]  # 각 노드에서 갈 수 있는 경로

        # 그래프 초기화
        for u, v, w in times:
            nodeArr[u-1].append((w, u-1, v-1))  # (가중치, 출발 노드, 도착 노드)

        # 시작 노드를 힙에 추가
        heapq.heappush(heap, (0, k-1))  # (가중치, 노드 번호)

        # 다익스트라 알고리즘
        while heap:
            current_weight, node = heapq.heappop(heap)

            # 이미 방문한 노드라면 건너뛰기
            if visited[node]:
                continue

            # 방문 표시
            visited[node] = True

            # 연결된 노드들 확인
            for weight, u, v in nodeArr[node]:
                if not visited[v] and weights[v] > current_weight + weight:
                    weights[v] = current_weight + weight
                    heapq.heappush(heap, (weights[v], v))

        # 도달할 수 없는 노드가 있다면 -1 반환
        max_time = max(weights)
        return max_time if max_time != float('inf') else -1
