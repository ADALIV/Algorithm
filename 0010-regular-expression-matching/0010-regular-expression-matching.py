class Solution(object):
    def isMatch(self, s, p):
        memo = {}  # (i, j) -> 결과 캐싱

        def dp(i, j):
            if (i, j) in memo:
                return memo[(i, j)]

            # 패턴 끝까지 다 봤을 경우
            if j == len(p):
                result = i == len(s)
            else:
                # 현재 글자 매치 여부 (단, i가 범위 안이어야 함)
                first_match = i < len(s) and (p[j] == s[i] or p[j] == '.')

                # 다음 문자가 '*'일 경우
                if (j + 1 < len(p)) and p[j + 1] == '*':
                    # 두 경우 중 하나라도 만족하면 됨:
                    # 1. '*'를 0번 쓰는 경우 → dp(i, j+2)
                    # 2. 현재 문자가 매치되면 '*'로 반복하는 경우 → dp(i+1, j)
                    result = dp(i, j + 2) or (first_match and dp(i + 1, j))
                else:
                    result = first_match and dp(i + 1, j + 1)

            memo[(i, j)] = result
            return result

        return dp(0, 0)
