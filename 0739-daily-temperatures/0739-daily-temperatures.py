class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        n = len(temperatures)
        answer = [0] * n  # 결과 배열 (기본값 0)
        stack = []  # 인덱스를 저장할 스택 (단조 감소 스택)

        for i, temp in enumerate(temperatures):
            # 현재 온도가 스택 top의 온도보다 높다면 정답 갱신
            while stack and temperatures[stack[-1]] < temp:
                prev_index = stack.pop()  # 이전 인덱스
                answer[prev_index] = i - prev_index  # 현재 인덱스 - 이전 인덱스
            stack.append(i)  # 현재 인덱스 추가
    
        return answer