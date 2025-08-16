def solution(diffs, times, limit):
    n = len(diffs)
    
    # 이진 탐색의 범위 설정 (lv는 최소 1부터 시작)
    left, right = 1, max(diffs)
    
    def calculate_spend(lv):
        spend = 0
        for i in range(n):
            diff = diffs[i] - lv
            time = times[i]
            if diff > 0:
                spend += (time + times[i-1]) * diff + time if i > 0 else (time * diff + time)
            else:
                spend += time
        return spend

    # 이진 탐색
    while left <= right:
        mid = (left + right) // 2
        spend = calculate_spend(mid)
        
        if spend <= limit:
            right = mid - 1  # limit 이하가 될 수 있는 더 작은 lv 값을 찾는다
        else:
            left = mid + 1   # spend가 limit을 초과하면 더 큰 lv 값을 찾아야 한다
    
    return left