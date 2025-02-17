from collections import deque

class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        dq = deque()
        n = len(temperatures)
        i = 0
        answer = [0]*n

        for i, temp in enumerate(temperatures):
            while dq and temperatures[dq[-1]]<temp:
                index = dq.pop()
                answer[index] = i - index
            dq.append(i)
        return answer